/**
 * @author pengfei.cheng
 * @description
 * @date 2019-07-22 19:08
 */
public class ReverseInteger {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     * <p>
     * 示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * <p>
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * <p>
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int reverse(int x) {
        int result = 0;
        int n = 1;
        if (x < 0) {
            n = -1;
            x = 0 - x;
        }
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        do {
            int i = x % 10;
            if (Integer.MAX_VALUE / 10 < result) {
                return 0;
            }
            result = result * 10 + i;
            x = x / 10;
        } while (x > 0);

        return n * result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
