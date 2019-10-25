import java.util.Arrays;

/**
 * @author pengfei.cheng
 * 37. 解数独
 * @since 2019/10/24 下午6:50
 */
public class SudokuSolver {
    /**
     * 编写一个程序，通过已填充的空格来解决数独问题。
     * <p>
     * 一个数独的解法需遵循如下规则：
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * <p>
     * 空白格用 '.' 表示。
     * Note:
     * <p>
     * 给定的数独序列只包含数字 1-9 和字符 '.' 。
     * 你可以假设给定的数独只有唯一解。
     * 给定数独永远是 9x9 形式的。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sudoku-solver
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char c = board[row][column];
                if (c == '.') {
                    continue;
                }
                int val = 1 << c - '1';//膜拜大神~ 整型二进制每一位代表一个数字
                int i = row / 3 * 3 + column / 3;
                rows[row] |= val;
                columns[column] |= val;
                boxes[i] |= val;
            }
        }
        setChar(board, rows, columns, boxes, 0);
    }

    private static boolean setChar(char[][] board, int[] rows, int[] columns, int[] boxes, int count) {
        if (count > 80) {
            return true;
        }
        int row = count / 9;
        int column = count % 9;
        char c = board[row][column];
        if (c != '.') {
            return setChar(board, rows, columns, boxes, ++count);
        }
        int box = row / 3 * 3 + column / 3;
        int i = rows[row] | columns[column] | boxes[box];
        for (int j = 0; j < 9; j++) {
            int val = 1 << j;
            if ((i & val) > 0) {
                continue;
            }
            board[row][column] = (char) (j + '1');
            rows[row] |= val;
            columns[column] |= val;
            boxes[box] |= val;
            if (setChar(board, rows, columns, boxes, ++count)) {
                return true;
            } else {
                count--;
                board[row][column] = c;
                rows[row] ^= val;
                columns[column] ^= val;
                boxes[box] ^= val;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] c = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(c);
        System.out.println(Arrays.deepToString(c));
    }

}
