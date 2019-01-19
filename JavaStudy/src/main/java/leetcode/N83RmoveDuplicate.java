package leetcode;

import java.util.List;

public class N83RmoveDuplicate {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        while (second != null) {
            if (first.val != second.val) {
                first.next = second;
                first = first.next;
            }
            second = second.next;
        }
        first.next = second;
        return head;
    }
}
