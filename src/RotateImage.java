/**
 * @author pengfei.cheng
 * 48. 旋转图像
 * @since 2019/11/26 上午9:59
 */
public class RotateImage {
    /**
     * 给定一个 n × n 的二维矩阵表示一个图像。
     * <p>
     * 将图像顺时针旋转 90 度。
     * <p>
     * 说明：
     * <p>
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     * <p>
     * 示例 1:
     * <p>
     * 给定 matrix =
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * <p>
     * 原地旋转输入矩阵，使其变为:
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-image
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void rotate(int[][] matrix) {
        int num = matrix.length - 1;
        for (int x = 0; x <= num; x++) {
            for (int y = 0; x >= y && x + y < num; y++) {
                int val = matrix[x][y];
                matrix[x][y] = matrix[num - y][x];
                matrix[num - y][x] = matrix[num - x][num - y];
                matrix[num - x][num - y] = matrix[y][num - x];
                matrix[y][num - x] = val;
            }
        }
    }

    public static void main(String[] args) {

    }
}
