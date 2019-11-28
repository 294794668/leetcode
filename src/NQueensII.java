/**
 * @author pengfei.cheng
 * 52. N皇后 II
 * @since 2019/11/28 下午2:54
 */
public class NQueensII {
    /**
     * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
     * <p>
     * 示例:
     * <p>
     * 输入: 4
     * 输出: 2
     * 解释: 4 皇后问题存在如下两个不同的解法。
     * [
     * [".Q..",  // 解法 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>
     * ["..Q.",  // 解法 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-queens-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private int result;
    private int n;

    public int totalNQueens(int n) {
        result = 0;
        this.n = n;
        for (int i = 0; i < n; i++) {
            solveNQueens(0, 0, i, 0, 0);
        }
        return result;
    }

    private void solveNQueens(int column, int x, int y, int lcross, int rcross) {
        int nc = column ^ (1 << y);
        if (nc < column) {
            return;
        }
        int nlc = lcross ^ (1 << (y + x));
        if (nlc < lcross) {
            return;
        }
        int nrc = rcross ^ (1 << (n + y - x));
        if (nrc < rcross) {
            return;
        }
        if (x == n - 1) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            solveNQueens(nc, x + 1, i, nlc, nrc);
        }
    }

    public static void main(String[] args) {
        System.out.println(new NQueensII().totalNQueens(4));
    }
}
