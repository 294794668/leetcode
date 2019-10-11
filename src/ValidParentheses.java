import java.util.Stack;

/**
 * @author pengfei.cheng
 * 20. 有效的括号
 * @since 2019/10/11 下午1:52
 */
public class ValidParentheses {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * <p>
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            Character pop = stack.peek();
            if ((pop == '(' && s.charAt(i) == ')')
                    || (pop == '[' && s.charAt(i) == ']')
                    || (pop == '{' && s.charAt(i) == '}')) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        for (Character character : stack) {
            if (character == '(' || character == ')'
                    || character == '[' || character == ']'
                    || character == '{' || character == '}') {
                return false;
            }
        }
        return true;
    }
}
