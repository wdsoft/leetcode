package com.github.wdsoft.linkedlist;

/**
 * Created by jwd on 2018/9/13.
 */
public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        int length = 0;
        ListNode p = head;
        for (; p != null; p = p.next) {
            length++;
        }

        //取余，看是最右侧的第几个节点
        k %= length;
        //找到从左往右的第k个节点
        k = length - k;
        p = head;
        for (; k > 1; k--) {
            p = p.next;
        }

        ListNode q = p.next;
        for (; q != null; q = q.next) {
            if (q.next == null) {
                break;
            }
        }

        //重新调整链表
        q.next = head;
        head = p.next;
        p.next = null;

        return head;
    }
}
