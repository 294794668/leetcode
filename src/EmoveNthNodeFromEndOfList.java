import java.util.HashMap;
import java.util.Map;

/**
 * @author pengfei.cheng
 * 19. 删除链表的倒数第N个节点
 * @since 2019/10/11 上午11:26
 */
public class EmoveNthNodeFromEndOfList {


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 示例：
     * <p>
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * <p>
     * 说明：
     * <p>
     * 给定的 n 保证是有效的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        while (temp != null) {
            map.put(i++, temp);
            temp = temp.next;
        }
        int key = i - n;
        if (key == 0) {
            return map.get(key + 1);
        }
        map.get(key - 1).next = map.get(key + 1);
        return head;
    }
}
