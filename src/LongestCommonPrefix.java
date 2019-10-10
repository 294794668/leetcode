/**
 * @author pengfei.cheng
 * 14. 最长公共前缀
 * @since 2019/10/10 下午2:20
 */
public class LongestCommonPrefix {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * <p>
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * <p>
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = null;
        for (String str : strs) {
            if (prefix == null) {
                prefix = str;
                continue;
            }
            if ("".equals(prefix)) {
                break;
            }
            int min = Math.min(prefix.length(), str.length());
            int effectiveLength = 0;
            for (int i = 0; i < min; i++) {
                if (prefix.charAt(i) != str.charAt(i)) {
                    break;
                }
                effectiveLength++;
            }
            prefix = prefix.substring(0, effectiveLength);
        }
        return prefix == null ? "" : prefix;
    }
}
