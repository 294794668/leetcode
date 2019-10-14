package test;

import sub.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
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
