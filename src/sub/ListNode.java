package sub;

/**
 * Definition for singly-linked list.
 *
 * @author pengfei.cheng
 * @since 2019/10/11 下午2:07
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode add(int x) {
        next = new ListNode(x);
        return next;
    }
}
