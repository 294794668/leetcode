import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengfei.cheng
 * 16. 最接近的三数之和
 * @since 2019/10/10 下午2:36
 */
public class ThreeSumClosest {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * <p>
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int smaller = nums[0] + nums[1] + nums[2];
        int bigger = nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int m = i + 1;
            int n = nums.length - 1;
            while (m < n) {
                if (m > i + 1 && nums[m] == nums[m - 1]) {
                    m++;
                    continue;
                }
                if (n < nums.length - 1 && nums[n] == nums[n + 1]) {
                    n--;
                    continue;
                }
                int sum = nums[m] + nums[n] + nums[i];
                if (sum < target) {
                    if (sum > smaller) {
                        smaller = sum;
                    }
                    m++;
                    continue;
                }
                if (sum > target) {
                    if (sum < bigger) {
                        bigger = sum;
                    }
                    n--;
                    continue;
                }
                return target;
            }
        }
        return Math.abs(bigger - target) > Math.abs(smaller - target) ? smaller : bigger;
    }

    public static void main(String[] args) {
        threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82);
    }
}
