/**
 * @author pengfei.cheng
 * @description 正则表达式匹配
 * @date 2019-07-23 16:30
 */
public class RegularExpressionMatching {
    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * <p>
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     * 说明:
     * <p>
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * <p>
     * 示例 2:
     * <p>
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * <p>
     * 示例 3:
     * <p>
     * 输入:
     * s = "ab"
     * p = ".*"
     * 输出: true
     * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * <p>
     * 示例 4:
     * <p>
     * 输入:
     * s = "aab"
     * p = "c*a*b"
     * 输出: true
     * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * <p>
     * 示例 5:
     * <p>
     * 输入:
     * s = "mississippi"
     * p = "mi.*is*p*."
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        if (p.length() < 1) {
            return false;
        }
        int pIndex = 0;
        int[] point = new int[p.length()];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char pChar = p.charAt(pIndex);
            if (isSame(sChar, pChar)) {
                pIndex++;
                continue;
            }
            if (pChar == '*') {
                if (isSame(sChar, p.charAt(pIndex - 1))) {
                    continue;
                }
                if (p.charAt(++pIndex) == sChar) {
                    continue;
                }
                return false;
            }
            return false;
        }
        if (p.length() != pIndex + 1) {

        }
        return true;
    }

    private boolean isSame(char a, char b) {
        if ('.' == b) {
            return true;
        }
        return a == b;
    }
}
