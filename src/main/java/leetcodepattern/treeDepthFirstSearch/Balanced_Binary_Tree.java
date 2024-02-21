package main.java.leetcodepattern.treeDepthFirstSearch;

import javax.swing.tree.TreeNode;

public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

//        int leftHeight = getHeight(root.left);
//        int rightHeight = getHeight(root.right);

        int leftHeight = 0;
		int rightHeight = 0;
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
