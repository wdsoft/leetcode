package com.github.wdsoft.linkedlist;

/**
 * Created by jwd on 2018/9/10.
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = 0;
        ListNode resultList = new ListNode(0);
        ListNode head = resultList;

        while (l1 != null && l2 != null) {
            ListNode node = new ListNode(0);
            node.val = (l1.val + l2.val + num) % 10;
            num = (l1.val + l2.val + num) / 10;
            resultList.next = node;
            l1 = l1.next;
            l2 = l2.next;
            resultList = resultList.next;
        }

        while (l1 != null) {
            ListNode node = new ListNode(0);
            node.val = (l1.val + num) % 10;
            num = (l1.val + num) / 10;
            resultList.next = node;
            l1 = l1.next;
            resultList = resultList.next;
        }

        while (l2 != null) {
            ListNode node = new ListNode(0);
            node.val = (l2.val + num) % 10;
            num = (l2.val + num) / 10;
            resultList.next = node;
            l2 = l2.next;
            resultList = resultList.next;
        }

        while (num != 0) {
            ListNode node = new ListNode(0);
            node.val = num % 10;
            num = num / 10;
            resultList.next = node;
            resultList = resultList.next;
        }

        return head.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
