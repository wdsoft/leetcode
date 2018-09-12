package com.github.wdsoft.linkedlist;

/**
 * Created by jwd on 2018/9/12.
 */
public class RemoveDuplicatesfromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        for (ListNode q = p.next; q != null; q = q.next) {
            if (p.val == q.val) {
                continue;
            } else {
                p.next = q;
                p = q;
            }
        }
        // 切断最后一个节点后面节点
        p.next = null;

        return head;
    }
}
