/**
 * @author pengfei.cheng
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * @since 2019/10/23 下午5:50
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * <p>
     * 示例 2:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] searchRange(int[] nums, int target) {
        int[] site = binarySearch(nums, 0, nums.length - 1, target);
        if (site[0] == -1) {
            return site;
        }
        int lastMiddle = (site[0] + site[1]) >>> 1;
        int a = search(nums, site[0], lastMiddle, target, true);
        int b = search(nums, lastMiddle, site[1], target, false);

        return new int[]{a, b};
    }

    private int search(int[] nums, int left, int right, int target, boolean b) {
        if (right < left) {
            return b ? left : right;
        }
        int middle = (left + right) >>> 1;
        if (nums[middle] > target) {
            return search(nums, left, middle - 1, target, b);
        } else if (nums[middle] < target) {
            return search(nums, middle + 1, right, target, b);
        } else if (b) {
            return search(nums, left, middle - 1, target, true);
        } else {
            return search(nums, middle + 1, right, target, false);
        }
    }

    public int[] binarySearch(int[] nums, int a, int b, int target) {
        if (a > b) {
            return new int[]{-1, -1};
        }
        int middle = (a + b) >>> 1;
        if (nums[middle] == target) {
            return new int[]{a, b};
        } else if (target < nums[middle]) {
            return binarySearch(nums, a, middle - 1, target);
        } else {
            return binarySearch(nums, middle + 1, b, target);
        }
    }
}
