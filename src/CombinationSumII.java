import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengfei.cheng
 * 40. 组合总和 II
 * @since 2019/10/28 下午4:35
 */
public class CombinationSumII {

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用一次。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。
     * <p>
     * 示例 1:
     * <p>
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * <p>
     * 示例 2:
     * <p>
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     * [1,2,2],
     * [5]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static int[] tmp = null;
    private static int tl;//tmp length

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        tmp = new int[candidates.length];
        combinationSum2(0, candidates, target, result);
        return result;
    }

    private static void combinationSum2(int idx, int[] c, int target, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < tl; i++) {
                list.add(tmp[i]);
            }
            result.add(list);
            return;
        }
        //出界返回
        if (idx >= c.length || target < 0) {
            return;
        }
        if (tmp[tl] != c[idx]) {
            tmp[tl] = c[idx];
            tl++;
            combinationSum2(idx + 1, c, target - c[idx], result);
            if (tmp.length > tl) {
                tmp[tl] = 0;
            }
            tl--;
        }
        combinationSum2(idx + 1, c, target, result);
    }



    //best
    public List<List<Integer>> combinationSum2Best(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> output, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            output.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], output, res);
            output.remove(output.size() - 1);
        }
    }
    public static void main(String[] args) {
        combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
