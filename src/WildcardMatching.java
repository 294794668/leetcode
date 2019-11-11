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
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = p.toCharArray();
        int al = 0;
        int bl = 0;
        int ar = a.length - 1;
        int br = b.length - 1;

        while (al <= ar && bl <= br && (a[al] == b[bl] || '?' == b[bl])) {
            al++;
            bl++;
        }
        while (al <= ar && bl <= br && (a[ar] == b[br] || '?' == b[br])) {
            ar--;
            br--;
        }
        if (br - bl == -1) {
            return ar - al == -1;
        }
        if (b[br] != '*' || b[bl] != '*') {
            return false;
        }

        return isMatch(a, al, ar, b, bl, br);

    }

    private static boolean isMatch(char[] a, int al, int ar, char[] b, int bl, int br) {
        if (al > ar) {
            //b匹配没有结束，则剩余结构必须是（字母*）或（*字母*）
            if (bl <= br) {
                for (int i = bl; i <= br; i++) {
                    if (b[i] != '*') {
                        return false;
                    }
                }
            }
            //b也匹配结束
            return true;
        }
        //a没结束b结束了。。。失败啊
        if (bl > br) {
            return false;
        }
        if (a[al] == b[bl] || b[bl] == '?') {
            return isMatch(a, ++al, ar, b, ++bl, br);
        } else if (b[bl] == '*') {
            if (bl < br && b[bl + 1] == '*') {
                bl++;
            }
            return isMatch(a, al, ar, b, bl + 1, br) || isMatch(a, al + 1, ar, b, bl, br);
        } else {
            return false;
        }
    }


    public static void main(String[] args) {

        System.out.println(isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
                "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }

}
