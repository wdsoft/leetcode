package com.github.wdsoft.linkedlist;

/**
 * Created by jwd on 2018/9/23.
 */
public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }

                return slow2;
            }
        }

        return null;
    }
}
