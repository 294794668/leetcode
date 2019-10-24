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
    public static boolean isMatch(String s, String p) {
        char[] a = s.toCharArray();
        char[] b = p.toCharArray();
        int ar = a.length - 1;
        int br = b.length - 1;
        while ((ar >= 0 && br >= 0) && (a[ar] == b[br] || b[br] == '.')) {
            ar--;
            br--;
        }
        //字符规律匹配完，字符匹配完成则匹配成功 否则失败
        if (br == -1) {
            return ar == -1;
        }
        //字符规律最后一位不是*，匹配失败
        if (b[br] != '*') {
            return false;
        }
        return isMatch(a, 0, ar, b, 0, br);
    }

    private static boolean isMatch(char[] a, int al, int ar, char[] b, int bl, int br) {
        //a全部匹配结束
        if (al > ar) {
            //b匹配没有结束，则剩余结构必须是（字母*）或（*字母*）
            if (bl < br) {
                int j = '*' == b[bl] ? 0 : 1;
                for (int i = bl + j; i <= br; i += 2) {
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
        if (a[al] == b[bl] || b[bl] == '.') {
            //匹配成功a b都向后移动一位
            return isMatch(a, ++al, ar, b, ++bl, br);
        } else if (b[bl] == '*') {
            //遇到匹配0或多，出现以下情况
            //1.停止匹配
            //2.继续匹配
            //3.忽略上一个匹配 0匹配————似乎出现重复
            int bl1 = bl + 1;
            int bl2 = bl - 1;
            return isMatch(a, al, ar, b, bl1, br) || isMatch(a, al, ar, b, bl2, br) || isMatch(a, --al, ar, b, bl1, br);
        } else {
            //不匹配但是后面是* 可以跳过
            //最后一位肯定是*，所以不存在数组越界
            if (b[++bl] == '*') {
                return isMatch(a, al, ar, b, ++bl, br);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("", "b."));
    }
}
