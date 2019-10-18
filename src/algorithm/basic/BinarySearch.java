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
        return iterateBinarySearch(sortArray, element);
    }

    /**
     * jdk的二分查找
     */
    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;
        int c = 0;
        while (low <= high) {
            System.out.println("--" + ++c);
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    /**
     * 二分查找（迭代实现）
     */
    private static int iterateBinarySearch(int[] sortArray, int key) {
        int low = 0;
        int high = sortArray.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int mVal = sortArray[mid];
            if (mVal < key)
                low = mid + 1;
            else if (mVal > key)
                high = mid - 1;
            else
                return mid;

        }
        return -1;
    }

    /**
     * 二分查找（递归实现）
     */
    private static int recursiveBinarySearch(int[] sortArray, int element) {
        return recursiveBinarySearch(sortArray, element, 0, sortArray.length - 1);
    }

    public static int recursiveBinarySearch(int[] sortArray, int element, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middle = (start + end) >>> 1;
        int mVal = sortArray[middle];
        if (mVal < element) {
            start = middle + 1;
        } else if (mVal > element) {
            end = middle - 1;
        } else {
            return middle;
        }
        return recursiveBinarySearch(sortArray, element, start, end);
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 4, 5, 6}, -1));
        System.out.println(binarySearch0(new int[]{1, 2, 4, 5, 6}, 0, 5, -1));
    }
}
