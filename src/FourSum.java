import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengfei.cheng
 * 18. 四数之和
 * @since 2019/10/11 上午10:57
 */
public class FourSum {
    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
     * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * <p>
     * 注意：
     * <p>
     * 答案中不可以包含重复的四元组。
     * <p>
     * 示例：
     * <p>
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * <p>
     * 满足要求的四元组集合为：
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int m = j + 1, n = nums.length - 1;
                while (m < n) {
                    if ((n < nums.length - 1 && nums[n] == nums[n + 1]) || nums[i] + nums[j] + nums[m] + nums[n] > target) {
                        n--;
                        continue;
                    }
                    if ((m > j + 1 && nums[m] == nums[m - 1]) || nums[i] + nums[j] + nums[m] + nums[n] < target) {
                        m++;
                        continue;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[m]);
                    list.add(nums[n]);
                    listList.add(list);
                    n--;
                    m++;
                }
            }
        }
        return listList;
    }
}
