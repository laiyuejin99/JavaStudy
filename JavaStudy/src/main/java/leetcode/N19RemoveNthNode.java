package leetcode;

public class N19RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) return null;
        ListNode dum = new ListNode(0);
        dum.next = head;

        ListNode pFirst = dum, pSecond = dum;
        for (int i = 0; i < n; i++) {
            pFirst = pFirst.next;
        }

        while (pFirst.next != null) {
            pFirst = pFirst.next;
            pSecond = pSecond.next;
        }
        pSecond.next = pSecond.next.next;
        return dum.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
