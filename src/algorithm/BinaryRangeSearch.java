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
    public int[] binaryRangeSearch(int[] array, int begin, boolean includeBegin, int end, boolean includeEnd) {
        if (begin > end) {
            return new int[]{};
        }
        int i = recursiveBinarySearch(array, begin, 0, array.length - 1, includeBegin);
        int i1 = recursiveBinarySearch(array, end, 0, array.length - 1, !includeEnd);
        return null;
    }

    private static int recursiveBinarySearch(int[] sortArray, int element, int start, int end, boolean left) {
        int middle;
        if (element == sortArray[(middle = (start + end) / 2)] && left) {
            return middle;
        }
        if (start == end) {
            return -1;
        }
        if (element > (sortArray[middle])) {
            start = middle;
        } else {
            end = middle / 2;
        }
        return recursiveBinarySearch(sortArray, element, start, end, left);
    }
}
