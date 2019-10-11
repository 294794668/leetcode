import sub.ListNode;

/**
 * @author pengfei.cheng
 * 21. 合并两个有序链表
 * @since 2019/10/11 下午2:08
 */
public class MergeTwoSortedLists {

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode result = first;
        while (l1 != null || l2 != null) {
            if (l1 != null && (l2 == null || l1.val < l2.val)) {
                first.next = l1;
                l1 = l1.next;
            } else {
                first.next = l2;
                l2 = l2.next;
            }
            first = first.next;
        }
        return result.next;
    }
}
