package com.github.wdsoft.linkedlist;

/**
 * Created by jwd on 2018/9/19.
 */
public class CopyListwithRandomPointer_138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        for (RandomListNode cur = head; cur != null;) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }

        for (RandomListNode cur = head; cur != null;) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        RandomListNode dummy = new RandomListNode(-1);
        for (RandomListNode cur = head, newCur = dummy; cur != null;) {
            newCur.next = cur.next;
            newCur = newCur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};
