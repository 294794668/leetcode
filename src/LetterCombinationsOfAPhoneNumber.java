import java.util.*;

/**
 * @author pengfei.cheng
 * 17. 电话号码的字母组合
 * @since 2019/10/10 下午7:57
 */
public class LetterCombinationsOfAPhoneNumber {


    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * 示例:
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> letterCombinations(String digits) {
        List<String> strings = new ArrayList<>();
        Map<Character, String[]> alphabetMap = new HashMap<>();
        alphabetMap.put('2', new String[]{"a", "b", "c"});
        alphabetMap.put('3', new String[]{"d", "e", "f"});
        alphabetMap.put('4', new String[]{"g", "h", "i"});
        alphabetMap.put('5', new String[]{"j", "k", "l"});
        alphabetMap.put('6', new String[]{"m", "n", "o"});
        alphabetMap.put('7', new String[]{"p", "q", "r", "s"});
        alphabetMap.put('8', new String[]{"t", "u", "v"});
        alphabetMap.put('9', new String[]{"w", "x", "y", "z"});
        for (char c : digits.toCharArray()) {
            String[] alphabets = alphabetMap.get(c);
            if (alphabets == null) {
                continue;
            }
            if (strings.isEmpty()) {
                strings.addAll(Arrays.asList(alphabets));
                continue;
            }
            List<String> temp = new ArrayList<>(alphabets.length * strings.size());
            for (String alphabet : alphabets) {
                for (String string : strings) {
                    temp.add(string + alphabet);
                }
            }
            strings = temp;
        }
        return strings;
    }
}
