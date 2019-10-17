package algorithm.basic;

/**
 * @author pengfei.cheng
 * 二分查找
 * @since 2019/10/17 上午10:12
 */
public class BinarySearch {

    /**
     * 二分查找
     *
     * @param sortArray
     * @param element
     */
    public static int binarySearch(int[] sortArray, int element) {
        return recursiveBinarySearch(sortArray, element);
    }

    /**
     * 二分查找（迭代实现）
     */
    private static int iterateBinarySearch(int[] sortArray, int element) {
        int last = 0;
        int next = sortArray.length - 1;
        int middle;
        while (element != (sortArray[(middle = (last + next) / 2)])) {
            if (last == next) {
                return -1;
            }
            if (element > (sortArray[middle])) {
                last = middle;
            } else {
                next = middle / 2;
            }
        }
        return middle;
    }

    /**
     * 二分查找（递归实现）
     */
    private static int recursiveBinarySearch(int[] sortArray, int element) {
        return recursiveBinarySearch(sortArray, element, 0, sortArray.length - 1);
    }

    public static int recursiveBinarySearch(int[] sortArray, int element, int start, int end) {
        int middle;
        if (element == sortArray[(middle = (start + end) / 2)]) {
            return middle;
        }
        if (start == end) {
            return -1;
        }
        if (element > (sortArray[middle])) {
            start = middle;
        } else {
            end = middle;
        }
        return recursiveBinarySearch(sortArray, element, start, end);
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 5));
    }
}
