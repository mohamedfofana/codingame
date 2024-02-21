package main.java.leetcodepattern.topKElements;

import java.util.Stack;

import main.java.codingame.arbre.TreeNode;


public class Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int result = 0;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (--k == 0) {
                result = root.val;
                break;
            }

            root = root.right;
        }

        return result;
    }
}
