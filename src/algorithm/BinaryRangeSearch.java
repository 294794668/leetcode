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
        int i = recursiveBinarySearch(array, begin, 0, array.length - 1, includeBegin);
        int j = recursiveBinarySearch(array, end, i, array.length - 1, !includeEnd);
        int[] result = new int[j - i + 1];
        System.arraycopy(array, i, result, 0, result.length);
        return result;
    }

    private static int recursiveBinarySearch(int[] sortArray, int element, int start, int end, boolean left) {
        if (start == end) {
            return start;
        }
        int middle = (start + end - 1) / 2;
        if (element > (sortArray[middle])) {
            start = middle;
        } else if (element < (sortArray[middle])) {
            end = middle;
        } else if (left) {
            end = middle;
        } else {
            start = middle;
        }
        return recursiveBinarySearch(sortArray, element, start, end, left);
    }

    public static void main(String[] args) {
        int[] ints = binaryRangeSearch(new int[]{2, 3, 3, 3, 3, 3, 3, 4, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 11, 12, 13, 14}, 1, true, 99, true);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
            System.out.print(",");
        }
    }
}
