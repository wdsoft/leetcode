package com.github.wdsoft.linkedlist;

/**
 * Created by jwd on 2018/9/12.
 */
public class RemoveDuplicatesfromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int count = 0;
        ListNode resultList = new ListNode(-1);
        ListNode next = resultList;
        ListNode p = head;
        ListNode q = p;
        while (p != null) {
            count = 0;
            q = p;
            while (q != null && q.val == p.val) {
                count++;
                q = q.next;
            }

            if (count == 1) {
                next.next = p;
                next = p;
            }
            p = q;
        }

        next.next = null;
        return resultList.next;
    }
}
