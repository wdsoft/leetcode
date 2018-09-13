package com.github.wdsoft.linkedlist;

/**
 * Created by jwd on 2018/9/13.
 */
public class RemoveNthNodeFromEndofList_19 {
    //遍历一次
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode slow = preHead;
        ListNode fast = preHead;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return preHead.next;
    }

    //遍历两次
    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        int length = 0;
        ListNode p = head;
        for (; p != null; p = p.next) {
            length++;
        }

        length = length - n;
        p = preHead;
        for (; length > 0; length--) {
            p = p.next;
        }

        p.next = p.next.next;

        return preHead.next;
    }*/
}
