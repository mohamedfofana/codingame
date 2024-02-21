package main.java.leetcodepattern.inplaceReveralofaLinkedList;

import main.java.leetcode.helperClass.ListNode;

public class Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            ListNode evenNext = even.next.next;

            odd.next = even.next;
            even.next = evenNext;
            odd = odd.next;
            even = evenNext;
        }

        odd.next = evenHead;
        return head;
    }
}
