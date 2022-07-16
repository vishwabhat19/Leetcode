package com.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree
{
	TreeNode root;

	BinaryTree() {
		root = null;
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) return false;

		if(root.key == targetSum && root.left == null && root.right == null)
			return true;

		boolean ans = false;
		int remainingSum = targetSum - root.key;

		if(root.left!=null)
			ans = ans || hasPathSum(root.left, remainingSum);
		if(root.right!=null)
			ans = ans || hasPathSum(root.right, remainingSum);

		return ans;
	}
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		System.out.println("Level Order Traversal");
		levelOrderTraversal(tree.root);
	}

	static void printPreOrder(TreeNode node) {
		//Root, Left, Right
		if(node!=null) {
			System.out.println(node.key);
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}

	/*
	Given the root of a binary tree, invert the tree, and return its root.
	 */
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		root.right = left;
		root.left = right;

		return root;
		
	}

	static void printPostOrder(TreeNode node) {
		//Left, Right, Node
		if(node!=null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.println(node.key);
		}
	}

	static void printInOrder(TreeNode node) {
		//Left, Root, Right
		if(node!=null) {
			printInOrder(node.left);
			System.out.println(node.key);
			printInOrder(node.right);
		}
	}

	static Queue<TreeNode> queue = new LinkedList<>();
	static void levelOrderTraversal(TreeNode node) {
		queue.offer(node);
		while(!queue.isEmpty()) {
			for(int i =0;i< queue.size();i++) {
				TreeNode firstNode = queue.poll();
				if(firstNode.left!=null) queue.offer(firstNode.left);
				if(firstNode.right!=null) queue.offer(firstNode.right);
				System.out.println(firstNode.key);
			}
		}
	}
}