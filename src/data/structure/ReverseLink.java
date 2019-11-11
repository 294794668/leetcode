package data.structure;

import sub.ListNode;

/**
 * @author pengfei.cheng
 * 反转单链表
 * @since 2019/11/11 下午6:34
 */
public class ReverseLink {

    public static ListNode reverse(ListNode listNode) {
        ListNode reverse = null;
        while (listNode != null) {
            ListNode nextNode = listNode.next;
            listNode.next = reverse;
            reverse = listNode;
            listNode = nextNode;
        }
        return reverse;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.add(2).add(3).add(4).add(5).add(6);
        ListNode reverse = ReverseLink.reverse(listNode);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
