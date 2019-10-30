/**
 * @author pengfei.cheng
 * 41. 缺失的第一个正数
 * @since 2019/10/29 下午2:57
 */
public class FirstMissingPositive {
    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,0]
     * 输出: 3
     * <p>
     * 示例 2:
     * <p>
     * 输入: [3,4,-1,1]
     * 输出: 2
     * <p>
     * 示例 3:
     * <p>
     * 输入: [7,8,9,11,12]
     * 输出: 1
     * <p>
     * 说明:
     * <p>
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/first-missing-positive
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int firstMissingPositive(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= 0) {
                continue;
            }
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        if (min > 1) {
            return 1;
        }
        int[] tmp = new int[nums.length];
        for (int num : nums) {
            if (num <= 0 || num > nums.length) {
                continue;
            }
            tmp[num - 1] = 1;
        }
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
    }
}
