import sub.ListNode;

/**
 * @author pengfei.cheng
 * 25. K 个一组翻转链表
 * @since 2019/10/12 下午5:54
 */
public class ReverseNodesInKGroup {

    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。
     * <p>
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 示例 :
     * <p>
     * 给定这个链表：1->2->3->4->5
     * <p>
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * <p>
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] listNodes = new ListNode[k];
        ListNode result = head;
        ListNode last = null;
        boolean flag = true;
        for (int i = 0; i < k && head != null; i++) {
            listNodes[i] = head;
            if (i == k - 1) {
                i = -1;
                if (flag) {
                    result = head;
                    flag = false;
                }
                listNodes[0].next = listNodes[k - 1].next;
                for (int j = k - 1; j > 0; j--) {
                    listNodes[j].next = listNodes[j - 1];
                }
                if (last != null) {
                    last.next = listNodes[k - 1];
                }
                head = listNodes[0];
                last = listNodes[0];
            }
            head = head.next;
        }
        return result;
    }
}
