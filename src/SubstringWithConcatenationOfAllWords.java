import java.util.*;

/**
 * @author pengfei.cheng
 * 30. 串联所有单词的子串
 * @since 2019/10/15 下午4:47
 */
public class SubstringWithConcatenationOfAllWords {

    /**
     * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     * <p>
     * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * s = "barfoothefoobarman",
     * words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
     * 输出的顺序不重要, [9,0] 也是有效答案。
     * <p>
     * 示例 2：
     * <p>
     * 输入：
     * s = "wordgoodgoodgoodbestword",
     * words = ["word","good","best","word"]
     * 输出：[]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> integers = new ArrayList<>();
        if (words.length == 0 || "".equals(s)) {
            return integers;
        }
        int wordLength = words[0].length();
        int minBegin = s.length() - words.length * wordLength;
        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (!count.containsKey(word)) {
                count.put(word, 1);
            } else {
                count.put(word, count.get(word) + 1);
            }
            int i = 0;
            while (i < s.length() && (i = s.indexOf(word, i)) != -1) {
                map.put(i, word);
                i++;
            }
        }
        a:
        for (Integer index : map.keySet()) {
            if (index > minBegin) {
                continue;
            }
            Map<String, Integer> count1 = new HashMap<>();
            count1.put(map.get(index), 1);
            for (int i = 1; i < words.length; i++) {
                int last = index + i * wordLength;
                if (!map.containsKey(last)) {
                    continue a;
                }
                String word = map.get(last);
                int times = 1;
                if (count1.containsKey(word)) {
                    times = count1.get(word) + 1;
                }
                count1.put(word, times);
                if (times > count.get(word)) {
                    continue a;
                }
            }
            integers.add(index);
        }
        return integers;
    }


    public List<Integer> findSubstringBest(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length == 0 || s.length() < words.length * words[0].length()) {
            return list;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        int listLen = words.length;
        int wordLen = words[0].length();

        for (int i = 0; i < wordLen; i++) {
            for (int j = i; j <= s.length() - wordLen * listLen; j += wordLen) {
                Map<String, Integer> map2 = new HashMap<>();
                for (int k = listLen - 1; k >= 0; k--) {
                    String temp = s.substring(j + k * wordLen, j + (k + 1) * wordLen);
                    int val = map2.getOrDefault(temp, 0) + 1;
                    if (val > map.getOrDefault(temp, 0)) {
                        j += k * wordLen;
                        break;
                    }
                    if (k == 0) {
                        list.add(j);
                    } else {
                        map2.put(temp, val);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("aaaaaaaa", new String[]{"aa", "aa", "aa"}));
    }
}
