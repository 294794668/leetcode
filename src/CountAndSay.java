/**
 * @author pengfei.cheng
 * 38. 报数
 * @since 2019/10/25 下午5:27
 */
public class CountAndSay {

    /**
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * <p>
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     * <p>
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     * <p>
     * 注意：整数顺序将表示为一个字符串。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1
     * 输出: "1"
     * <p>
     * 示例 2:
     * <p>
     * 输入: 4
     * 输出: "1211"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-and-say
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = countAndSay(s);
        }
        return s;
    }

    private String countAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int time = 1;
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                time++;
                continue;
            }
            sb.append(time).append(c);
            time = 1;
            c = s.charAt(i);
        }
        sb.append(time).append(c);
        return sb.toString();
    }
}
