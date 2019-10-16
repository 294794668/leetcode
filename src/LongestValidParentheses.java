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
    public int longestValidParentheses(String s) {
        int length = 0;
        int max = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.empty()) {
                int j = 0;
                Character pop = null;
                while (!stack.empty() && (pop = stack.pop()) == '2') {
                    j++;
                }
                if (pop == ')') {
                    stack.push(')');
                }
                for (int i1 = 0; i1 < j; i1++) {
                    stack.push('2');
                }
                if (pop == '(') {
                    stack.push('2');
                }
                if (pop == ')') {
                    stack.push(')');
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        for (Character character : stack) {
            if (character == '2') {
                length += 2;
            } else {
                max = Math.max(max, length);
                length = 0;
            }
        }
        return Math.max(max, length);
    }
}
