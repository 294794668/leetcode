import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<List<Integer>> permute(int[] nums) {
        int size = 1;
        for (int length = nums.length; length > 0; length--) {
            size *= length;
        }
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                continue;
            }
        }

        while (length > 0) {
            int index = nums.length - length;
//            for (int k = 1; k <= result.size() / size; k++) {
//                size /= length;
//                for (int i = 1; i <= length; i++) {
//                    for (int j = 1; j <= size; j++) {
//                        result.get(i * j - 1).set(index, 0);
//                    }
//                }
//            }
            for (int i = 0; i < size; i++) {
                int position = 0;
                List<Integer> list = result.get(i);
                list.add(index, nums[position]);
            }
            length--;
        }
        return result;
    }
}
