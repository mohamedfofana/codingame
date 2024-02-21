package main.java.leetcodepattern.treeDepthFirstSearch;

import main.java.codingame.arbre.TreeNode;

public class Search_in_a_Binary_Search_Tree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode curr = root;

        while (curr != null) {
            if (curr.val == val) {
                return curr;
            } else if (curr.val > val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return null;
    }
}
