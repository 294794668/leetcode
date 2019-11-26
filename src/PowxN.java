/**
 * @author pengfei.cheng
 * 50. Pow(x, n)
 * @since 2019/11/26 下午4:28
 */
public class PowxN {
    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * <p>
     * 示例 2:
     * <p>
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * <p>
     * 示例 3:
     * <p>
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
     * <p>
     * 说明:
     * <p>
     * -100.0 < x < 100.0
     * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/powx-n
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 1) {
            x = 1 / x;
            n = -n;
        }
        return 0d;
    }

    public static void main(String[] args) {
//        double n = 2.1d;
//        System.out.println(n << 3);
//        System.out.println(myPow(1, 2));
    }
}
