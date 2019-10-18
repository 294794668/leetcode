package algorithm;

import java.util.Arrays;

/**
 * @author pengfei.cheng
 * 二分范围查找
 * @since 2019/10/17 上午11:10
 */
public class BinaryRangeSearch {

    /**
     * 二分查找范围，可以理解为数据库查询索引 包括>=/>/</<=
     * 有=时 include 为 true
     * 22223 > 2 返回4，>=2 返回0
     */
    public static int[] binaryRangeSearch(int[] array, int begin, boolean includeBegin, int end, boolean includeEnd) {
        if (begin > end) {
            return new int[]{};
        }
        int i = binaryRangeSearch0(array, begin, 0, array.length - 1, includeBegin, true);
        if (i >= array.length) {
            return new int[]{};
        }
        int j = binaryRangeSearch0(array, end, i, array.length - 1, !includeEnd, false);
        if (j <= 0) {
            return new int[]{};
        }
        int[] result = new int[j - i + 1];
        System.arraycopy(array, i, result, 0, result.length);
        return result;
    }

    private static int binaryRangeSearch0(int[] array, int element, int start, int end, boolean left, boolean size) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            int mVal = array[mid];
            if (mVal > element)
                end = mid - 1;
            else if (mVal < element)
                start = mid + 1;
            else if (left)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return size ? start : end;
    }

    public static void main(String[] args) {
        int[] ints1 = {4, 5, 5, 5, 6};
        System.out.println(Arrays.toString(binaryRangeSearch(ints1, 5, true, 100, true)));
    }
}
