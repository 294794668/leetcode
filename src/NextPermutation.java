import java.util.Arrays;

/**
 * @author pengfei.cheng
 * 31. 下一个排列
 * @since 2019/10/15 下午6:48
 */
public class NextPermutation {
    /**
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * <p>
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * <p>
     * 必须原地修改，只允许使用额外常数空间。
     * <p>
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void nextPermutation(int[] nums) {
        //1,3,2 → 2,1,3
        if (nums.length <= 1) {
            return;
        }
        int point = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                point = i;
                break;
            }
        }
        Arrays.sort(nums, point + 1, nums.length);
        if (point == -1) {
            return;
        }
        for (int i = point + 1; i < nums.length; i++) {
            if (nums[i] > nums[point]) {
                int num = nums[point];
                nums[point] = nums[i];
                nums[i] = num;
                break;
            }
        }
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{2, 3, 1});
    }
}
