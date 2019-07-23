import java.util.Arrays;

/**
 * @author pengfei.cheng
 * @description
 * @date 2019-07-22 14:36
 */
public class LongestPalindrome {

    /**
     * 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * <p>
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     */
    public String longestPalindrome(String s) {
        String longestSubString = "";
        for (int i = 0; i < s.length(); i++) {
            if (longestSubString.length() > s.length() - i) {
                return longestSubString;
            }
            for (int j = i + longestSubString.length(); j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    longestSubString = s.substring(i, j + 1);
                }
            }
        }
        return longestSubString;
    }

    private boolean isPalindrome(String s, int i, int j) {
        for (int k = 0; k < (j - i + 1) / 2; k++) {
            if (s.charAt(i + k) != s.charAt(j - k)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Manacher 算法
     */
    public String longestPalindromeManacher(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        String str = sb.toString();
        String longestPalindrome = "";
        int center = 0;
        int[] radius = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            while (i - radius[i] > 0 && i + radius[i] < str.length()) {
                if (str.charAt(i - radius[i]) == str.charAt(i + radius[i])) {
                    radius[i]++;
                }
            }
        }

        return longestPalindrome;
    }

//
//
//    // 预处理字符串，在两个字符之间加上#
//    private String preHandleString(String s) {
//        StringBuffer sb = new StringBuffer();
//        int len = s.length();
//        sb.append('#');
//        for (int i = 0; i < len; i++) {
//            sb.append(s.charAt(i));
//            sb.append('#');
//        }
//        return sb.toString();
//    }
//
//    // 寻找最长回文字串
//    public String longestPalindromeBest(String s) {
//        // 先预处理字符串
//        String str = preHandleString(s);
//        // 处理后的字串长度
//        int len = str.length();
//        // 右边界
//        int rightSide = 0;
//        // 右边界对应的回文串中心
//        int rightSideCenter = 0;
//        // 保存以每个字符为中心的回文长度一半（向下取整）
//        int[] halfLenArr = new int[len];
//        // 记录回文中心
//        int center = 0;
//        // 记录最长回文长度
//        int longestHalf = 0;
//        for (int i = 0; i < len; i++) {
//            // 是否需要中心扩展
//            boolean needCalc = true;
//            // 如果在右边界的覆盖之内
//            if (rightSide > i) {
//                // 计算相对rightSideCenter的对称位置
//                int leftCenter = 2 * rightSideCenter - i;
//                // 根据回文性质得到的结论
//                halfLenArr[i] = halfLenArr[leftCenter];
//                // 如果超过了右边界，进行调整
//                if (i + halfLenArr[i] > rightSide) {
//                    halfLenArr[i] = rightSide - i;
//                }
//                // 如果根据已知条件计算得出的最长回文小于右边界，则不需要扩展了
//                if (i + halfLenArr[leftCenter] < rightSide) {
//                    // 直接推出结论
//                    needCalc = false;
//                }
//            }
//            // 中心扩展
//            if (needCalc) {
//                while (i - 1 - halfLenArr[i] >= 0 && i + 1 + halfLenArr[i] < len) {
//                    if (str.charAt(i + 1 + halfLenArr[i]) == str.charAt(i - 1 - halfLenArr[i])) {
//                        halfLenArr[i]++;
//                    } else {
//                        break;
//                    }
//                }
//                // 更新右边界及中心
//                rightSide = i + halfLenArr[i];
//                rightSideCenter = i;
//                // 记录最长回文串
//                if (halfLenArr[i] > longestHalf) {
//                    center = i;
//                    longestHalf = halfLenArr[i];
//                }
//            }
//        }
//        // 去掉之前添加的#
//        StringBuilder sb = new StringBuilder();
//        for (int i = center - longestHalf + 1; i <= center + longestHalf; i += 2) {
//            sb.append(str.charAt(i));
//        }
//        return sb.toString();
//    }
}