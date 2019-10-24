/**
 * @author pengfei.cheng
 * 35. 搜索插入位置
 * @since 2019/10/24 上午10:04
 */
public class SearchInsertPosition {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * <p>
     * 示例 2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * <p>
     * 示例 3:
     * <p>
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * <p>
     * 示例 4:
     * <p>
     * 输入: [1,3,5,6], 0
     * 输出: 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int searchInsert(int[] nums, int target) {
        if (0 == nums.length) {
            return 0;
        }
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int l, int r, int target) {
        if (l > r) {
            return l;
        }
        int middle = (l + r) >>> 1;
        if (nums[middle] > target) {
            return binarySearch(nums, 0, middle - 1, target);
        } else if (nums[middle] < target) {
            return binarySearch(nums, middle + 1, r, target);
        } else {
            return middle;
        }
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

}
