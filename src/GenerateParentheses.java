import java.util.ArrayList;
import java.util.List;

/**
 * @author pengfei.cheng
 * 22. 括号生成
 * @since 2019/10/11 下午2:25
 */
public class GenerateParentheses {


    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * <p>
     * 例如，给出 n = 3，生成结果为：
     * <p>
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> generateParenthesis(int n) {
        List<String> strings = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < i; j++) {
                s.insert(j, "()");
            }
            strings.add(s.toString());
        }
        return strings;
    }
}
