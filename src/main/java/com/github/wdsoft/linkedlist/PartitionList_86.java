package com.github.wdsoft.linkedlist;

/**
 * Created by jwd on 2018/9/11.
 */
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(-1);
        ListNode rightHead = new ListNode(-1);

        ListNode left_index = leftHead;
        ListNode right_index = rightHead;
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val < x) {
                left_index.next = p;
                left_index = left_index.next;
            } else {
                right_index.next = p;
                right_index = right_index.next;
            }
        }

        left_index.next = null;
        right_index.next = null;
        left_index.next = rightHead.next;

        return leftHead.next;
    }
}
