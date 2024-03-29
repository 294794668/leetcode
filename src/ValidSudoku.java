import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author pengfei.cheng
 * 36. 有效的数独
 * @since 2019/10/24 上午10:25
 */
public class ValidSudoku {

    /**
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * <p>
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * 示例 1:
     * <p>
     * 输入:
     * [<p>
     * ['5','3','.','.','7','.','.','.','.'],<p>
     * ['6','.','.','1','9','5','.','.','.'],<p>
     * ['.','9','8','.','.','.','.','6','.'],<p>
     * ['8','.','.','.','6','.','.','.','3'],<p>
     * ['4','.','.','8','.','3','.','.','1'],<p>
     * ['7','.','.','.','2','.','.','.','6'],<p>
     * ['.','6','.','.','.','.','2','8','.'],<p>
     * ['.','.','.','4','1','9','.','.','5'],<p>
     * ['.','.','.','.','8','.','.','7','9']<p>
     * ]
     * 输出: true
     * <p>
     * 示例 2:
     * <p>
     * 输入:
     * [<p>
     * ['8','3','.','.','7','.','.','.','.'],<p>
     * ['6','.','.','1','9','5','.','.','.'],<p>
     * ['.','9','8','.','.','.','.','6','.'],<p>
     * ['8','.','.','.','6','.','.','.','3'],<p>
     * ['4','.','.','8','.','3','.','.','1'],<p>
     * ['7','.','.','.','2','.','.','.','6'],<p>
     * ['.','6','.','.','.','.','2','8','.'],<p>
     * ['.','.','.','4','1','9','.','.','5'],<p>
     * ['.','.','.','.','8','.','.','7','9']<p>
     * ]
     * 输出: false
     * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
     * <p>
     * 说明:
     * <p>
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 给定数独序列只包含数字 1-9 和字符 '.' 。
     * 给定数独永远是 9x9 形式的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-sudoku
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-sudoku
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> hashSets = new ArrayList<>(18);
        for (int i = 0; i < 19; i++) {
            hashSets.add(new HashSet<>());
        }
        for (int x = 0; x < board.length; x++) {
            int a = x / 3;
            for (int y = 0; y < board[x].length; y++) {
                if ('.' == board[x][y]) {
                    continue;
                }
                if (!hashSets.get(0).add(board[x][y])
                        || !hashSets.get(y + 1).add(board[x][y])
                        || !hashSets.get(a + (y / 3 * 3) + 10).add(board[x][y])) {
                    return false;
                }
            }
            hashSets.set(0, new HashSet<>());
        }
        return true;
    }

    public static boolean isValidSudokuBest(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char c = board[row][column];
                if (c == '.') {
                    continue;
                }
                int val = 1 << c - '1';//膜拜大神~ 整形二进制每一位代表一个数字
                int i = row / 3 * 3 + column / 3;
                if (((rows[row] | columns[column] | boxes[i]) & val) > 0) {
                    return false;
                }
                rows[row] |= val;
                columns[column] |= val;
                boxes[i] |= val;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                int i = row / 3 * 3 + column / 3;
                System.out.print(row);
                System.out.print(" ");
                System.out.print(i);
                System.out.print(" ");
                System.out.println(column);
            }
        }
//        System.out.println(isValidSudoku(new char[][]{
//                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
//                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
//                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
//                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
//        }));
    }
}
