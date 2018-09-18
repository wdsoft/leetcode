package com.github.wdsoft.linkedlist;

/**
 * Created by jwd on 2018/9/18.
 */
public class ReverseNodesinkGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode prev = dummy, end = head; end != null; end = prev.next) {
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }
            //不够k个，直接结束返回
            if (end == null) {
                break;
            }

            prev = reversList(prev, prev.next, end);
        }

        return dummy.next;
    }

    ListNode reversList(ListNode prev, ListNode start, ListNode end) {
        ListNode endNext = end.next;
        ListNode tmprev = prev;
        for (ListNode cur = start, next = cur.next; cur != endNext;) {
            cur.next = tmprev;
            tmprev = cur;
            cur = next;
            next = cur == null ? null : cur.next;
        }

        start.next = endNext;
        prev.next = end;
        return start;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ReverseNodesinkGroup_25 obj = new ReverseNodesinkGroup_25();
        obj.reverseKGroup(node1, 2);
    }
}
