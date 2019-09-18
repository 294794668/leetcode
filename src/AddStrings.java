/**
 * @author pengfei.cheng
 * @description 字符串相加
 * @date 2019-09-18 10:26
 */
public class AddStrings {

    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * <p>
     * 注意：
     * <p>
     * num1 和num2 的长度都小于 5100.
     * num1 和num2 都只包含数字 0-9.
     * num1 和num2 都不包含任何前导零。
     * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String addStrings(String num1, String num2) {
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int add = 0;
        int max = array1.length > array2.length ? array1.length : array2.length;
        for (int i = 1; i <= max; i++) {
            int i1 = array1.length >= i ? array1[array1.length - i] - '0' : 0;
            int i2 = array2.length >= i ? array2[array2.length - i] - '0' : 0;
            int i3 = i1 + i2 + add;
            if (i3 >= 10) {
                sb.append(i3 - 10);
                add = 1;
            } else {
                sb.append(i3);
                add = 0;
            }
        }
        if (add ==  1) {
            sb.append(add);
        }
        return sb.reverse().toString();
    }

}
