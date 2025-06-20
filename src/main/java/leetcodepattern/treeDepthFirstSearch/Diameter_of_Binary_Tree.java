package main.java.leetcodepattern.treeDepthFirstSearch;

import main.java.codingame.arbre.TreeNode;

public class Diameter_of_Binary_Tree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lDepth = helper(root.left);
        int rDepth = helper(root.right);

        max = Math.max(max, lDepth + rDepth);

        return Math.max(lDepth, rDepth) + 1;
    }
}
