package com.github.wdsoft.linkedlist;

/**
 * Created by jwd on 2018/9/10.
 */
public class ReverseLinkedList_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(0);
        ListNode post = null;
        ListNode p = head;
        ListNode result = pre;

        pre.next = head;
        for (int i = 0; i < m - 1; i++) {
            pre = p;
            p = p.next;
        }

        p = head;
        for (int i = 0; i < n - 1; i++) {
            p = p.next;
        }
        post = p.next;

        ListNode list = reverseList(pre.next, p);

        pre.next = list;
        for (p = list; p.next != null; p = p.next);
        p.next = post;

        return result.next;
    }

    ListNode reverseList(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode next = null;
        ListNode stop = end == null ? null : end.next;

        while (start != stop) {
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }

        return end;
    }
}
