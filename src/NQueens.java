import java.util.*;
import java.util.stream.Collectors;

/**
 * @author pengfei.cheng
 * 51. N皇后
 * @since 2019/11/27 下午3:23
 */
public class NQueens {
    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 即任意两个皇后都不能处于同一行、同一列或同一斜线上
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     * <p>
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     * 示例:
     * <p>
     * 输入: 4
     * 输出: [
     * [".Q..",  // 解法 1
     * "...Q",
     * "Q...",
     * "..Q."],
     * <p>–
     * ["..Q.",  // 解法 2
     * "Q...",
     * "...Q",
     * ".Q.."]
     * ]
     * 解释: 4 皇后问题存在两个不同的解法。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-queens
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.clear();
            solveNQueens(0, 0, 0, i, n, 0, 0, stack, result);
        }
        return result;
    }

    private void solveNQueens(int row, int column, int x, int y, int n, int lcross, int rcross,
                              Stack<String> stack, List<List<String>> result) {
        stack.push(generateRow(y, n));
        System.out.println(stack);
        int nr = row ^ (1 << x);
        if (nr <= row) {
            return;
        }
        int nc = column ^ (1 << y);
        if (nc <= column) {
            return;
        }
        int nlc = lcross ^ (1 << (y + x));
        if (nlc <= lcross) {
            return;
        }
        int nrc = rcross ^ (1 << (y - x + n));
        if (nrc <= rcross) {
            return;
        }
        if (stack.size() == n) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < n; i++) {
            solveNQueens(nr, nc, x + 1, i, n, nlc, nrc, stack, result);
            stack.pop();
        }
    }

    private String generateRow(int y, int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        chars[y] = 'Q';
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}
