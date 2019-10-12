import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengfei.cheng
 * 22. 括号生成
 * @since 2019/10/11 下午2:25
 */
public class GenerateParentheses {
    private List<String> list = new ArrayList<>();

    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * <p>
     * 例如，给出 n = 3，生成结果为：
     * <p>
     * [
     * "((()))",3-1
     * "(()())",2-1
     * "(())()",21-2
     * "()(())",12-2
     * "()()()"1-3
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //---------------------穷举法--------(((((((((((((
    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return list;
        else {
            add(n, "(", 1);//调用递归函数 并填入初始值
            return list;
        }
    }

    private void add(int n, String s, int count) {
        //递归终止条件 当字符串长度等于n*2-1的时候进行判断 防止字符串无限长
        if (s.length() == n * 2 - 1) {
            //如果此时 count为1 说明字符串符合条件
            if (count == 1) {
                list.add(s + ")");
                return;
            }
            return;
        }
        //这层for循环用来生成 i==0时"(" 或 i==1时“）”
        //先判断count状态
        if (count > 0) {
            for (int i = 0; i < 2; i++) {
                if (i == 0)
                    add(n, s + "(", count + 1);
                else
                    add(n, s + ")", count - 1);
            }//end for
        } else if (count == 0) {
            add(n, s + "(", count + 1);
        }
    }//end method

    //---------------)))))))))))
    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(5));
    }
}
