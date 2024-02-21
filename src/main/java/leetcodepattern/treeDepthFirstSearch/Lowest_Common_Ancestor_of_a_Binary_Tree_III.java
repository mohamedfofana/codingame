package main.java.leetcodepattern.treeDepthFirstSearch;

import java.util.HashSet;
import java.util.Set;

import main.java.codingame.arbre.Node;

public class Lowest_Common_Ancestor_of_a_Binary_Tree_III {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> pParents = new HashSet<>();

        while (p != null) {
            pParents.add(p);
            p = p.parent;
        }

        while (q != null) {
            if (pParents.contains(q)) {
                return q;
            }

            q = q.parent;
        }

        return null;
    }
}
