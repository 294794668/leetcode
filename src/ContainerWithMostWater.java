/**
 * @author pengfei.cheng
 * @description 盛最多水的容器
 * @date 2019-09-06 17:20
 */
public class ContainerWithMostWater {

    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int i1 = i + 1; i1 < height.length; i1++) {
                max = Math.max(Math.min(height[i], height[i1]) * (i1 - i), max);
            }
        }
        return max;
    }


    public int maxAreaBest(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (r - l > 0) {
            max = Math.max(Math.min(height[r], height[l]) * (r - l), max);
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
