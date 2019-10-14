/**
 * @author pengfei.cheng
 * 28. 实现 strStr()
 * @since 2019/10/14 下午3:51
 */
public class ImplementStrstr {

    /**
     * 实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * <p>
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int sourceLength = haystack.length();
        int targetLength = needle.length();

        int max = sourceLength - targetLength;
        for (int i = 0; i <= max; i++) {
            while (source[i] != target[0] && ++i <= max) ;
            if (i <= max) {
                int k = 1;
                for (int j = i + 1; k < targetLength && source[j] == target[k]; k++, j++) ;
                if (k == targetLength) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int indexOf(String haystack, String needle) {
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int sourceCount = source.length;
        int targetCount = target.length;
        if (0 >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (targetCount == 0) {
            return 0;
        }

        char first = target[0];
        int max = (sourceCount - targetCount);

        for (int i = 0; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = 1; j < end && source[j]
                        == target[k]; j++, k++)
                    ;

                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }
}
