package main.java.leetcodepattern.treeDepthFirstSearch;

import main.java.codingame.arbre.TreeNode;

public class Lowest_Common_Ancestor_of_a_Binary_Tree_II {
    private boolean pFound = false, qFound = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = helper(root, p, q);

        if (pFound && qFound && result != null) {
            return result;
        }
        return null;
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        if (root == p) {
            pFound = true;
            return root;
        }

        if (root == q) {
            qFound = true;
            return root;
        }

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }
}
