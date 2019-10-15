/**
 * @author pengfei.cheng
 * 29. 两数相除
 * @since 2019/10/14 下午5:27
 */
public class DivideTwoIntegers {
    /**
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * <p>
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     * <p>
     * 示例 1:
     * <p>
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * <p>
     * 示例 2:
     * <p>
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * <p>
     * 说明:
     * <p>
     * 被除数和除数均为 32 位有符号整数。
     * 除数不为 0。
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divide-two-integers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        int quotient = 0;
        boolean flag = dividend > 0 ^ divisor > 0;
        boolean over = false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend < 0 && divisor < 0) {
            return 1;
        }
        if (divisor < 0) {
            return 0;
        }
        if (dividend < 0 && !flag && divisor == 1) {
            return Integer.MAX_VALUE;
        }
        if (dividend < 0) {
            dividend = Integer.MAX_VALUE;
            over = true;
        }
        String dividendStr = Integer.toBinaryString(dividend);
        String divisorStr = Integer.toBinaryString(divisor);
        int dividendLength = dividendStr.length();
        int divisorLength = divisorStr.length();
        for (int i = dividendLength - divisorLength; i >= 0; i--) {
            int a = dividend - (divisor << i);
            quotient = quotient << 1;
            if (a >= 0) {
                dividend = a;
                quotient++;
            }
        }
        if (over) {
            if (++dividend >= divisor) {
                quotient++;
            }
        }
        if (flag) {
            quotient = -quotient;
        }
        return quotient;
    }

    public static void main(String[] args) {
        divide(Integer.MIN_VALUE, 2);
    }
}