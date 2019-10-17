package algorithm;

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
    public static <E extends Comparable> int binarySearch(int[] sortArray, int element) {
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

    public static int biSearch(int[] array, int a) {
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;//中间位置
            if (array[mid] == a) {
                return mid;
            } else if (array[mid] < a) {
                // 向右查找
                lo = mid + 1;
            } else {
                // 向左查找
                hi = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 4));
    }
}
