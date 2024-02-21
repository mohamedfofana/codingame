package main.java.leetcodepattern.treeBreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = q.poll();
//                tempList.add(temp.val);
//
//                if (temp.left != null) {
//                    q.offer(temp.left);
//                }
//                if (temp.right != null) {
//                    q.offer(temp.right);
//                }
            }

            result.add(0, tempList);
        }

        return result;
    }
}
