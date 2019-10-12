import sub.ListNode;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author pengfei.cheng
 * 23. 合并K个排序链表
 * @since 2019/10/12 下午2:46
 */
public class MergeKSortedLists {

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * <p>
     * [
     * <p>
     * 1->4->5,
     * <p>
     * 1->3->4,
     * <p>
     * 2->6
     * <p>
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        List<ListNode> nodes = Arrays.stream(lists).filter(Objects::nonNull).sorted(Comparator.comparingInt(o -> o.val)).collect(Collectors.toList());
        while (!nodes.isEmpty()) {
            cursor.next = nodes.get(0);
            if (nodes.size() == 1) {
                break;
            }
            cursor = cursor.next;
            if (cursor.next == null) {
                nodes.remove(0);
            } else {
                nodes.set(0, cursor.next);
                if (nodes.get(0).val > nodes.get(1).val) {
                    bubble(nodes);
                }
            }
        }
        return head.next;
    }

    private void bubble(List<ListNode> nodes) {
        if (nodes == null || nodes.size() <= 1) {
            return;
        }
        ListNode first = nodes.get(0);
        int index = 0;
        for (int i = 1; i < nodes.size(); i++) {
            if (first.val <= nodes.get(i).val) {
                break;
            }
            index++;
        }
        if (index == 0) return;
        nodes.remove(0);
        nodes.add(index, first);
    }

    /**
     * best
     */
    public ListNode mergeKListsBest(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        return mergeKLists(lists, 0, len - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        // 思考这里为什么取等于？这是因为根据下文对 mergeKLists 的递归调用情况，区间最窄的时候，只可能是左右端点重合
        if (l == r) {
            return lists[l];
        }
        int mid = (r - l) / 2 + l;
        ListNode l1 = mergeKLists(lists, l, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, r);
        return mergeTwoSortedListNode(l1, l2);
    }

    private ListNode mergeTwoSortedListNode(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoSortedListNode(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoSortedListNode(l1, l2.next);
        return l2;
    }

}
