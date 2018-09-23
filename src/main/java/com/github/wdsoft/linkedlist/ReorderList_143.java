package com.github.wdsoft.linkedlist;

/**
 * Created by jwd on 2018/9/23.
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
        //先中分，再将后半部反序，最后将两个链表重新合并
        if (head == null || head.next == null) {
            return;
        }

        int length = 0;
        for (ListNode p = head; p != null; p = p.next) {
            length++;
        }

        //step1：拆分两个为链表
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode p = preHead;
        for (int i = 0; i < (length+1)/2; i++) {
            p = p.next;
        }
        ListNode head2 = p.next;
        p.next = null;

        //step2：反转第二个链表
        head2 = reverseList(head2);

        //step3：合并两个链表
        ListNode newHead = new ListNode(-1);
        p = newHead;
        ListNode p1 = head;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            p.next = p1;
            p1 = p1.next;
            p = p.next;
            p.next = null;

            p.next = p2;
            p = p.next;
            p2 = p2.next;
            p.next = null;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        head = newHead.next;
        return;
    }

    ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ReorderList_143 obj = new ReorderList_143();
        obj.reorderList(node1);
    }
}
