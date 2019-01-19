package leetcode;

public class N21MergeTwoSortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dum = new ListNode(0);
        ListNode res = dum;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                dum.next = p1;
                p1 = p1.next;
            } else {
                dum.next = p2;
                p2 = p2.next;
            }
            dum = dum.next;
        }
        if (p1 != null) {
            dum.next = p1;
        } else {
            dum.next = p2;
        }
        return res.next;
    }
}
