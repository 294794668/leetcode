import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author pengfei.cheng
 * 32. 最长有效括号
 * @since 2019/10/16 下午1:38
 */
public class LongestValidParentheses {
    /**
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     * <p>
     * 示例 2:
     * <p>
     * 输入: ")()())"
     * 输出: 4
     * 解释: 最长有效括号子串为 "()()"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int longestValidParentheses(String s) {
        int max = 0;
        Stack<Map.Entry<Integer, Character>> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.empty()) {
                Map.Entry<Integer, Character> pop = stack.pop();
                if (pop.getValue() != '(') {
                    stack.push(pop);
                    stack.push(new HashMap.SimpleEntry<>(i, s.charAt(i)));
                }
            } else {
                stack.push(new HashMap.SimpleEntry<>(i, s.charAt(i)));
            }
        }
        if (stack.empty()) {
            return s.length();
        }
        int index = -1;
        for (Map.Entry<Integer, Character> integerCharacterEntry : stack) {
            int i = integerCharacterEntry.getKey() - index - 1;
            index = integerCharacterEntry.getKey();
            max = Math.max(max, i);
        }
        return Math.max(max, s.length() - index - 1);
    }

    public static void main(String[] args) {
        longestValidParentheses("(()(((()");
    }
}
