/**
 * @author pengfei.cheng
 * 43. 字符串相乘
 * @since 2019/10/30 下午6:45
 */
public class MultiplyStrings {
    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * <p>
     * 示例 1:
     * <p>
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * <p>
     * 示例 2:
     * <p>
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * <p>
     * 说明：
     * <p>
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/multiply-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        char[] aCharArray = num1.toCharArray();
        char[] bCharArray = num2.toCharArray();
        int max = aCharArray.length + bCharArray.length - 1;
        int up = 0;
        for (int i = 0; i < max; i++) {
            int sum = 0;
            if (i < aCharArray.length) {
                for (int j = 0; j <= i; j++) {
                    sum += (aCharArray[j] - '0') * (bCharArray[i - j] - '0');
                }
                sum += up;
            } else {
                int b = i - aCharArray.length;
                sum = (aCharArray[aCharArray.length - 1] - '0') * (bCharArray[b] - '0') + up;
            }
            sb.append(sum % 10);
            up = sum / 10;
        }
        if (up != 0) {
            sb.append(up);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("999999", "999999999999"));
    }
}