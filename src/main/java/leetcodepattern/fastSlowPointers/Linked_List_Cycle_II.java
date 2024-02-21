package main.java.leetcodepattern.fastSlowPointers;

import main.java.leetcode.helperClass.ListNode;

public class Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        Boolean isCyclic = false;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCyclic = true;
                break;
            }
        }

        if (!isCyclic) {
            return null;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
