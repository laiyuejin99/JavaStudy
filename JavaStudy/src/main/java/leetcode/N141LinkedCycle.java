package leetcode;

public class N141LinkedCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            slow = slow.next;
            if (fast == null) return false;
            if (fast.next != null)
                fast = fast.next.next;
            else
                return false;
        }
        return true;
    }

}
