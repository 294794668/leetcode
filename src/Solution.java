import sub.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    /**
     * 1.给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
     * 并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public int[] twoSumBest(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 2.给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
     * 并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNode = new ListNode(0);
        ListNode endNode = firstNode;
        boolean more = false;
        while (l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int i = l1Val + l2Val;
            if (more) {
                i += 1;
            }
            more = i >= 10;
            if (more) {
                i -= 10;
            }
            endNode.next = new ListNode(i);
            endNode = endNode.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (more) {
            endNode.next = new ListNode(1);
        }
        return firstNode.next;
    }

    /**
     * 3.给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * <p>
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int subLength = 0;
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (i + subLength >= chars.length) {
                break;
            }
            if (i > 0) {
                characters.remove(chars[i - 1]);
            }
            for (int j = i + characters.size(); j < chars.length; j++) {
                if (!characters.add(chars[j])) {
                    if (characters.size() > subLength) {
                        subLength = characters.size();
                    }
                    break;
                }
            }
            if (characters.size() > subLength) {
                subLength = characters.size();
            }
        }
        return subLength;
    }

    public int lengthOfLongestSubstringBest(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * <p>
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 则中位数是 2.0
     * <p>
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 则中位数是 (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] all = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, all, 0, nums1.length);
        System.arraycopy(nums2, 0, all, nums1.length, nums2.length);
        Arrays.sort(all);
        if (all.length % 2 == 1) {
            return all[all.length / 2];
        }
        return (all[all.length / 2] + all[(all.length - 2) / 2]) / 2d;
    }

    public static double findMedianSortedArraysBest(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m >= n) {
            return findBinary(nums1, nums2, (nums2.length + 1) / 2);
        }
        return findBinary(nums2, nums1, (nums1.length + 1) / 2);
    }

    private static double findBinary(int[] bNum, int[] sNum, int i) {
        int j = (bNum.length + sNum.length + 1) / 2 - i; // 2(j+i)  = bNum.length + sNum.length + 1
        if (j > sNum.length) {
            findBinary(bNum, sNum, i + (i + 1) / 2);
        }
        if (j < 1) {
            findBinary(bNum, sNum, i - (i + 1) / 2);
        }

        int b_s = bNum[i - 1];
        int s_s = sNum[j - 1];
        if (i == bNum.length) {
            int s_b = sNum[j];
            if ((bNum.length + sNum.length) % 2 == 1) {
                return s_b;
            }
            return (Math.max(s_s, b_s) + s_b) / 2d;
        }
        if (j == sNum.length) {
            
        }

        int b_b = bNum[i];
        int s_b = sNum[j];

        //2个数组都已找到
        if (b_s <= s_b && s_s <= b_b) {
            if ((bNum.length + sNum.length) % 2 == 1) {
                return Math.min(s_b, b_b);
            }
            return (Math.max(s_s, b_s) + Math.min(s_b, b_b)) / 2d;
        }
        //i有点小
        if (s_s > b_b) {
            findBinary(bNum, sNum, i + (i + 1) / 2);
        }
        //i有点大
        if (b_s > s_b) {
            findBinary(bNum, sNum, i - (i + 1) / 2);
        }
        return 0d;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArraysBest(new int[]{1, 3}, new int[]{2}));
    }
}