package main.java.codingame.arbre;

import java.util.LinkedList;
import java.util.Queue;

public class HeightDepthBinaryTree {
	
	class NodeVal {
	    int data;
	    NodeVal left;
	    NodeVal right;
	 
	    NodeVal(int item) {
	        data = item;
	        left = right = null;
	    }
	}
	
	static NodeVal newNode(int value) {
		return new HeightDepthBinaryTree().new NodeVal(value);
	}

	static void findDepthAndHeight(NodeVal root, int k) {
		if (root == null)
			return;

		int depth = -1;
		int height = -1;

		Queue<NodeVal> q = new LinkedList<>();
		q.add(root);
		int level = 0;

		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 0; i < n; i++) {
				NodeVal frontNode = q.poll();
				if (frontNode.data == k)
					depth = level;
				if (frontNode.left != null)
					q.add(frontNode.left);
				if (frontNode.right != null)
					q.add(frontNode.right);
			}
			level++;
		}

		height = level - depth - 1;
		System.out.println("Depth : " + depth);
		System.out.println("Height : " + height);
	}

	public static void main(String[] args) {
		// Binary Tree Formation
		NodeVal root = newNode(5);
		root.left = newNode(10);
		root.right = newNode(15);
		root.left.left = newNode(20);
		root.left.right = newNode(25);
		root.left.right.right = newNode(45);
		root.right.left = newNode(30);
		root.right.right = newNode(35);

		int k = 25;

		findDepthAndHeight(root, k);
	}
}
