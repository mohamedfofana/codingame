package main.java.leetcodepattern.treeBreadthFirstSearch;

import main.java.codingame.arbre.Node;

public class Populating_Next_Right_Pointers_in_Each_Node {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node curr = root;

        while (curr != null) {
            Node next = curr.left;

            if (next == null) {
                break;
            }

//            while (curr != null) {
//                curr.left.next = curr.right;
//
//                if (curr.next != null) {
//                    curr.right.next = curr.next.left;
//                }
//
//                curr = curr.next;
//            }

            curr = next;
        }

        return root;
    }
}
