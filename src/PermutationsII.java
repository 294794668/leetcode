import java.util.*;

/**
 * @author pengfei.cheng
 * 47. 全排列 II
 * @since 2019/11/25 下午5:43
 */
public class PermutationsII {
    /**
     * todo 暂时想不出来
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,1,2]
     * 输出:
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ints = new ArrayList<>(nums.length);
        for (int num : nums) {
            ints.add(num);
        }
        permuteUnique(ints, list, 0);
        return list;
    }

    private void permuteUnique(List<Integer> nums, List<List<Integer>> list, int i) {

        if (i == nums.size()) {
            list.add(nums);
        }
        for (int j = i; j < nums.size(); j++) {
            if (i != j && nums.get(i).compareTo(nums.get(j)) == 0) {
                continue;
            }
            Collections.swap(nums, i, j);
            // use next integers to complete the permutations
            permuteUnique(nums, list, i + 1);
            // backtrack
            Collections.swap(nums, i, j);
        }
    }

}
