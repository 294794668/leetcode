package algorithm;

import algorithm.basic.BinarySearch;

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
        int i = recursiveBinarySearch(array, begin, 0, array.length - 1, true);
        int j = recursiveBinarySearch(array, end, i, array.length - 1, false);
        int[] result = new int[j - i + 1];
        System.arraycopy(array, i, result, 0, result.length);
        return result;
    }

    private static int recursiveBinarySearch(int[] sortArray, int element, int start, int end, boolean left) {
        if (start == end) {
            return start;
        }
//        int n = left ? 1 : 0;
        int middle = (start + end) / 2;
        if (element > (sortArray[middle])) {
            start = middle + 1;
        } else if (element < (sortArray[middle])) {
            end = middle - 1;
        } else if (left) {
            end = middle;
        } else {
            start = middle;
        }
        return recursiveBinarySearch(sortArray, element, start, end, left);
    }

    public static void main(String[] args) {
        int[] ints1 = {2, 3, 3, 3, 3, 3, 3, 4, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 11, 12, 13, 14};
        System.out.println(recursiveBinarySearch(ints1, 3, 0, ints1.length - 1, true));
    }
}
