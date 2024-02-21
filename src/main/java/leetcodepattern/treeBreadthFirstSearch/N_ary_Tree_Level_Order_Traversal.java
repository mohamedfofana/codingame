package main.java.leetcodepattern.treeBreadthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.codingame.arbre.Node;

public class N_ary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int level = q.size();

            for (int i = 0; i < level; i++) {
                Node n = q.poll();
//                temp.add(n.val);
//
//                for (int j = 0; j < n.children.size(); j++) {
//                    q.offer(n.children.get(j));
//                }
            }

            res.add(temp);
        }

        return res;
    }
}
