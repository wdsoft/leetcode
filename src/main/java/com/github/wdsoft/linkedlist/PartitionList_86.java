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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        PartitionList_86 obj = new PartitionList_86();
        obj.partition(node1, 3);
    }
}
