package main.java.leetcodepattern.treeDepthFirstSearch;

import java.util.HashSet;
import java.util.Set;

import main.java.codingame.arbre.TreeNode;


public class Two_Sum_IV_Input_is_a_BST {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }

        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }
}
