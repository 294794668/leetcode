import java.util.*;

/**
 * @author pengfei.cheng
 * 46. 全排列
 * @since 2019/11/22 上午11:22
 */
public class Permutations {

    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
        if (first == n) {
            output.add(new ArrayList<>(nums));
        }
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            System.out.println(nums + " " + first + " " + i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList<>();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        p.permute(new int[]{1, 2, 3, 4, 5});
    }


    public List<List<Integer>> permute1(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 使用哈希表检测一个数字是否使用过
        Set<Integer> used = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        backtrack(nums, 0, len, used, stack, res);
        return res;
    }

    private void backtrack(int[] nums, int depth, int len, Set<Integer> used, Stack<Integer> stack, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used.contains(i)) {
                used.add(i);
                stack.push(nums[i]);

                backtrack(nums, depth + 1, len, used, stack, res);

                stack.pop();
                used.remove(i);
            }
        }
    }

}
