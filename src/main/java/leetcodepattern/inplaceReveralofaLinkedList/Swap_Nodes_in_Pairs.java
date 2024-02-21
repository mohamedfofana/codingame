package main.java.leetcodepattern.inplaceReveralofaLinkedList;

import main.java.leetcode.helperClass.ListNode;

public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1), curr = dummy;
        dummy.next = head;

        while (curr.next != null && curr.next.next != null) {
            ListNode p = curr.next;
            curr.next = p.next;
            p.next = curr.next.next;
            curr.next.next = p;
            curr = p;
        }

        return dummy.next;
    }
}
