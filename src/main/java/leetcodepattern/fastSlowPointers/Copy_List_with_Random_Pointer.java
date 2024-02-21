package main.java.leetcodepattern.fastSlowPointers;

import java.util.HashMap;
import java.util.Map;

import main.java.codingame.arbre.Node;

public class Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> hm = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            Node deepCopy = new Node(curr.val, null, null);
            hm.put(curr, deepCopy);
//            curr = curr.next;
        }

        for (Map.Entry<Node, Node> entry : hm.entrySet()) {
            Node n = entry.getValue();
//            n.next = hm.get(entry.getKey().next);
//            n.random = hm.get(entry.getKey().random);
        }

        return hm.get(head);
    }
}
