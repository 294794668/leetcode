import sub.ListNode;

/**
 * @author pengfei.cheng
 * 24. 两两交换链表中的节点
 * @since 2019/10/12 下午5:17
 */
public class SwapNodesInPairs {

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        ListNode oddNode = head;
        ListNode evenNode = head;
        for (int i = 1; head != null; i++) {
            if (i == 2) {
                temp = head;
            }
            if (i % 2 == 0) {
                evenNode.next = head;
                oddNode.next = head.next;
                head.next = oddNode;
                head = oddNode.next;
            } else {
                evenNode = oddNode;
                oddNode = head;
                head = head.next;
            }
        }
        return temp;
    }
}
