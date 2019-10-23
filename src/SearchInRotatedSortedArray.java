/**
 * @author pengfei.cheng
 * 33. 搜索旋转排序数组
 * @since 2019/10/16 下午5:51
 */
public class SearchInRotatedSortedArray {

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * 你可以假设数组中不存在重复的元素。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * <p>
     * 示例 2:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int search(int[] nums, int target) {
        if (0 == nums.length) {
            return -1;
        }
        int n = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[n] > nums[i]) {
                n = i;
                break;
            }
        }
        if (0 == n) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        if (nums[0] == target) {
            return 0;
        } else if (target > nums[0]) {
            return binarySearch(nums, 1, n, target);
        } else {
            return binarySearch(nums, n, nums.length - 1, target);
        }
    }

    private static int binarySearch(int[] nums, int a, int b, int target) {
        if (a > b) {
            return -1;
        }
        int middle = (a + b) >>> 1;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] < target) {
            return binarySearch(nums, middle + 1, b, target);
        } else {
            return binarySearch(nums, a, middle - 1, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 3}, 3));
    }
}
