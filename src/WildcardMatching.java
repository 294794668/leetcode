/**
 * 44. 通配符匹配
 */
public class WildcardMatching {
    /**
     * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     * <p>
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * <p>
     * 两个字符串完全匹配才算匹配成功。
     * <p>
     * 说明:
     * <p>
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
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
     * p = "*"
     * 输出: true
     * 解释: '*' 可以匹配任意字符串。
     * <p>
     * 示例 3:
     * <p>
     * 输入:
     * s = "cb"
     * p = "?a"
     * 输出: false
     * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     * <p>
     * 示例 4:
     * <p>
     * 输入:
     * s = "adceb"
     * p = "*a*b"
     * 输出: true
     * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
     * <p>
     * 示例 5:
     * <p>
     * 输入:
     * s = "acdcb"
     * p = "a*c?b"
     * 输入: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/wildcard-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static boolean isMatch(String s, String p) {
        int i = 0, j = 0, m = s.length(), n = p.length();
        int last = -1;
        int match = 0;
        while (i < m) {
            if (j < n && (s.charAt(i) == p.charAt(j) || '?' == p.charAt(j))) {
                i++;
                j++;
            } else if (j < n && '*' == p.charAt(j)) {
                last = j;
                match = i;
                j++;
            } else if (last != -1) {
                j = last;
                i = ++match;
            } else {
                return false;
            }
        }
        while (j < n) {
            if (p.charAt(j) != '*')
                return false;
            j++;
        }
        return true;
    }

}
