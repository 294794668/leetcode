/**
 * @author pengfei.cheng
 * @description
 * @date 2019-07-22 18:11
 */
public class Conversion {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * <p>
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * <p>
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * <p>
     * 请你实现这个将字符串进行指定行数变换的函数：
     * <p>
     * string convert(string s, int numRows);
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * <p>
     * 示例 2:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     */
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }
        int length = 2 * numRows - 2;//6
        int a = s.length() / length + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < a; j++) {
                if (j * length + i >= s.length()) {
                    continue;
                }
                sb.append(s.charAt(j * length + i));
                if (i != 0 && i != numRows - 1) {
                    if ((j + 1) * length - i >= s.length()) {
                        continue;
                    }
                    sb.append(s.charAt((j + 1) * length - i));
                }
            }
        }
        return sb.toString();
    }
}
