/**
 * @author pengfei.cheng
 * 42. 接雨水
 * @since 2019/10/30 上午11:14
 */
public class TrappingRainWater {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int area = 0;
        int minHighMax = 0;
        while (l < r) {
            if (height[l] == 0) {
                l++;
                continue;
            }
            if (height[r] == 0) {
                r--;
                continue;
            }
            int minHeight = Math.min(height[l], height[r]);
            if (minHeight <= minHighMax) {
                area -= minHeight;
            } else {
                int length = r - l - 1;
                area -= minHighMax;
                area += (minHeight - minHighMax) * length;
                minHighMax = Math.max(minHeight, minHighMax);
            }
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
