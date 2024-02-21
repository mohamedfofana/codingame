package main.java.leetcodepattern.treeDepthFirstSearch;

import main.java.codingame.arbre.TreeNode;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);

        if (leftSearch == null) {
            return rightSearch;
        }
        if (rightSearch == null) {
            return leftSearch;
        }

        return root;
    }
}
