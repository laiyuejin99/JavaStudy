package leetcode;

import java.util.List;

public class N24SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode top = dummy;
        while (first != null && second != null) {
            top.next = second;
            first.next = second.next;
            second.next = first;
            top = top.next.next;
            first = top.next;
            if (first == null || first.next == null)
                break;
            second = first.next;
        }
        return dummy.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
