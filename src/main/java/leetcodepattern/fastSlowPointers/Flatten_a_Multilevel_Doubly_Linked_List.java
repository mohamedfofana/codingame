package main.java.leetcodepattern.fastSlowPointers;

import java.util.Stack;

import main.java.codingame.arbre.Node;

public class Flatten_a_Multilevel_Doubly_Linked_List {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Node dummy = new Node(-1, null, head, null);
        Node curr, prev = dummy;

        Stack<Node> st = new Stack<>();
        st.push(head);

        while (!st.isEmpty()) {
            curr = st.pop();

//            prev.next = curr;
//            curr.prev = prev;
//
//            if (curr.next != null) {
//                st.push(curr.next);
//            }
//
//            if (curr.child != null) {
//                st.push(curr.child);
//                curr.child = null;
//            }

            prev = curr;
        }

//        dummy.next.prev = null;
//        return dummy.next; // vrai
        return null;
    }
}
