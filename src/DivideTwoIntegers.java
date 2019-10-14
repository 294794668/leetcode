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
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        int i = 0;
        boolean flag = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        if (dividend == Integer.MIN_VALUE) {
            dividend = Integer.MAX_VALUE;
        }
        dividend = (dividend < 0) ? -dividend : dividend;
        divisor = (divisor < 0) ? -divisor : divisor;
        if (divisor > dividend) {
            return 0;
        }
        i = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            i++;
        }
        if (flag) {
            i = -i;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(1 << 31);
        System.out.println(Integer.MIN_VALUE);
        System.out.println((1 << 31) - 1);
        System.out.println(Integer.MAX_VALUE);
    }
}