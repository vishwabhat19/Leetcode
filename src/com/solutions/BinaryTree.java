package com.solutions;

public class BinaryTree
{
	TreeNode root;

	BinaryTree() {
		root = null;
	}
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		System.out.println("In Order");
		printInOrder(tree.root);
		System.out.println("Post Order");
		printPostOrder(tree.root);
		System.out.println("Pre Order");
		printPreOrder(tree.root);
	}

	static void printPreOrder(TreeNode node) {
		if(node!=null) {
			System.out.println(node.key);
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}

	/*
	PostOrder prints left node first then right node and then root node
	45231
	 */
	static void printPostOrder(TreeNode node) {
		if (node!=null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.println(node.key);
		}
	}

	/*
	In Order prints left node first then root and then right node
	 */
	static void printInOrder(TreeNode root) {
		if(root!=null) {
			printInOrder(root.left);
			System.out.println(root.key);
			printInOrder(root.right);
		}
	}
}
