package main.java.leetcodepattern.treeDepthFirstSearch;

import java.util.HashSet;
import java.util.Set;

import main.java.codingame.arbre.TreeNode;


public class Lowest_Common_Ancestor_of_a_Binary_Tree_IV {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> s = new HashSet<>();

        for (TreeNode n : nodes) {
            s.add(n);
        }

        return helper(root, s);
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> s) {
        if (root == null) {
            return null;
        }

        if (s.contains(root)) {
            return root;
        }

        TreeNode left = helper(root.left, s);
        TreeNode right = helper(root.right, s);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        return root;
    }
}
