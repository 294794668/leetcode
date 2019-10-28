import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pengfei.cheng
 * 39. 组合总和
 * @since 2019/10/25 下午6:17
 */
public class CombinationSum {

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * <p>
     * 示例 1:
     * <p>
     * 输入: candidates = [2,3,6,7], target = 7,
     * 所求解集为:
     * [
     * [7],
     * [2,2,3]
     * ]
     * <p>
     * 示例 2:
     * <p>
     * 输入: candidates = [2,3,5], target = 8,
     * 所求解集为:
     * [
     * [2,2,2,2],
     * [2,3,3],
     * [3,5]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            int start = candidates[i];
            int a = target / start;
            if (a == 0) {
                break;
            }
            int[] array = new int[a];
            for (int j = a; j > 0; j--) {
                Arrays.fill(array, i);
                int sum = sum(array, j, candidates);
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    for (int k = 0; k < j; k++) {
                        list.add(candidates[array[k]]);
                    }
                    lists.add(list);
                }
                while (arrayPlus(array, j, candidates.length - 1)) {
                    if (sum(array, j, candidates) == target) {
                        List<Integer> list = new ArrayList<>();
                        for (int k = 0; k < j; k++) {
                            list.add(candidates[array[k]]);
                        }
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }

    private static int sum(int[] array, int a, int[] candidates) {
        int sum = 0;
        for (int i1 = 0; i1 < a; i1++) {
            int i = array[i1];
            sum += candidates[i];
        }
        return sum;
    }

    private static boolean arrayPlus(int[] array, int a, int max) {
        if (a == 1) {
            return false;
        }
        int i;
        for (i = a - 1; i > 0; i--) {
            if (array[i] != max) {
                break;
            }
        }
        if (i == 0) {
            return false;
        }
        array[i] = ++array[i];
        for (int j = i + 1; j < a; j++) {
            array[j] = array[i];
        }
        return true;
    }


    public static List<List<Integer>> ans = new ArrayList<>();
    public static int[] path = new int[100];
    public static int len;


    public List<List<Integer>> combinationSumBest(int[] candidates, int target) {
        dfs(0, candidates, target);
        return ans;
    }

    public static void dfs(int idx, int[] c, int target) {
        if (target == 0) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                tmp.add(path[i]);
            }
            ans.add(tmp);
            return;
        }
        //出界返回
        if (idx >= c.length || target < 0) {
            return;
        }

        //用当前数
        path[len] = c[idx];
        len++;
        //下次还可以用，状态变化是目标值减少
        dfs(idx, c, target - c[idx]);

        //不用当前数
        len--;
        dfs(idx + 1, c, target);

    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{6, 7, 3, 2}, 11));
    }

}
