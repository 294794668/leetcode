/**
 * @author pengfei.cheng
 * @description 整数转罗马数字
 * @date 2019-09-06 17:49
 */
public class IntegerToRoman {

    /**
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * <p>
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * <p>
     * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 3
     * 输出: "III"
     * <p>
     * 示例 2:
     * <p>
     * 输入: 4
     * 输出: "IV"
     * <p>
     * 示例 3:
     * <p>
     * 输入: 9
     * 输出: "IX"
     * <p>
     * 示例 4:
     * <p>
     * 输入: 58
     * 输出: "LVIII"
     * 解释: L = 50, V = 5, III = 3.
     * <p>
     * 示例 5:
     * <p>
     * 输入: 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-to-roman
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < num / 1000; i++) {
            roman.append("M");
        }
        num = num % 1000;
        if (num >= 900) {
            roman.append("CM");
            num = num - 900;
        }
        for (int i = 0; i < num / 500; i++) {
            roman.append("D");
        }
        num = num % 500;
        if (num >= 400) {
            roman.append("CD");
            num = num - 400;
        }
        for (int i = 0; i < num / 100; i++) {
            roman.append("C");
        }
        num = num % 100;
        if (num >= 90) {
            roman.append("XC");
            num = num - 90;
        }
        for (int i = 0; i < num / 50; i++) {
            roman.append("L");
        }
        num = num % 50;
        if (num >= 40) {
            roman.append("XL");
            num = num - 40;
        }
        for (int i = 0; i < num / 10; i++) {
            roman.append("X");
        }
        num = num % 10;
        if (num >= 9) {
            roman.append("IX");
            num = num - 9;
        }
        for (int i = 0; i < num / 5; i++) {
            roman.append("V");
        }
        num = num % 5;
        if (num == 4) {
            roman.append("IV");
            num = num - 9;
        }
        for (int i = 0; i < num; i++) {
            roman.append("I");
        }
        return roman.toString();
    }

    public String intToRomanBest(int num) {
        int[] ints = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] flags = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder roman = new StringBuilder();
        for (int length = ints.length - 1; length >= 0; length--) {
            num = this.appendRoman(num, length, ints, flags, roman);
        }
        return roman.toString();
    }

    private int appendRoman(int num, int length, int[] ints, String[] chars, StringBuilder roman) {
        for (int i = 0; i < num / ints[length]; i++) {
            roman.append(chars[length]);
        }
        return num % ints[length];
    }
}
