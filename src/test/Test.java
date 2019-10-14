package test;

import sub.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(-5 / 10);
        System.out.println((5 << 3) + 5);//5*9
        System.out.println((25 >> 4) + "  " + (25 >> 2));//25/12
    }

    public ListNode revert(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode revert = revert(head.next);
        head.next = null;
        revert.next = head;
        return head;
    }
}
