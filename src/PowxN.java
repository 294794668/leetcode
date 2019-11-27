import java.util.Arrays;

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
        double result = 1;
        double last = 1;
        boolean b = n < 0;
        if (b) {
            n = -n;
        }
        char[] nc = Integer.toBinaryString(n).toCharArray();
        for (int i = nc.length - 1; i >= 0; i--) {
            if (i == nc.length - 1) {
                last *= x;
            } else {
                last *= last;
            }
            if (nc[i] == '1') {
                result *= last;
            }
        }
        if (b) {
            result = 1 / result;
        }
        return result;
    }


    public static double myPowBest(double x, int n) {
        double res = 1.0;

        for (int i = n; i != 0; i /= 2) {

            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }

        return n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(3, 3));
    }
}
