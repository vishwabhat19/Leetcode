package com.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree
{
	TreeNode root;

	BinaryTree()
	{
		root = null;
	}

	public boolean hasPathSum(TreeNode root, int targetSum)
	{
		if (root == null)
			return false;

		if (root.key == targetSum && root.left == null && root.right == null)
			return true;

		boolean ans = false;
		int remainingSum = targetSum - root.key;

		if (root.left != null)
			ans = ans || hasPathSum(root.left, remainingSum);
		if (root.right != null)
			ans = ans || hasPathSum(root.right, remainingSum);

		return ans;
	}

	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(9);
		tree.root.right = new TreeNode(20);
		tree.root.right.left = new TreeNode(15);
		tree.root.right.right = new TreeNode(7);
		findLeafSequence(tree.root);
		list1.forEach(System.out::println);
	}

	static void printPreOrder(TreeNode node)
	{
		//Root, Left, Right
		if (node != null)
		{
			System.out.println(node.key);
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}

	/*
	Given the root of a binary tree, invert the tree, and return its root.
	 */
	public TreeNode invertTree(TreeNode root)
	{
		if (root == null)
			return null;

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		root.right = left;
		root.left = right;

		return root;

	}

	static void printPostOrder(TreeNode node)
	{
		//Left, Right, Node
		if (node != null)
		{
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.println(node.key);
		}
	}

	static void printInOrder(TreeNode node)
	{
		//Left, Root, Right
		if (node != null)
		{
			printInOrder(node.left);
			System.out.println(node.key);
			printInOrder(node.right);
		}
	}

	static Queue<TreeNode> queue = new LinkedList<>();

	static void levelOrderTraversal(TreeNode node)
	{
		queue.offer(node);
		while (!queue.isEmpty())
		{
			for (int i = 0; i < queue.size(); i++)
			{
				TreeNode firstNode = queue.poll();
				if (firstNode.left != null)
					queue.offer(firstNode.left);
				if (firstNode.right != null)
					queue.offer(firstNode.right);
				System.out.println(firstNode.key);
			}
		}
	}

	static boolean areCousins(TreeNode root, int x, int y)
	{
		if (root == null)
			return false;
		queue.offer(root);
		while (!queue.isEmpty())
		{
			int size = queue.size();
			boolean xPresent = false;
			boolean yPresent = false;
			for (int i = 0; i < size; i++)
			{

				TreeNode currentNode = queue.poll();
				if (currentNode.key == x)
					xPresent = true;
				if (currentNode.key == y)
					yPresent = true;
				//Same Parent check starts
				if (currentNode.left != null && currentNode.right != null)
				{
					if (currentNode.left.key == x && currentNode.right.key == y)
					{
						return false;
					}
					if (currentNode.left.key == y && currentNode.right.key == x)
					{
						return false;
					}
				}
				//Same Parent check ends
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
				if (xPresent && yPresent)
					return true;
			}
		}
		return false;
	}

	public static boolean isSameTree(TreeNode p, TreeNode q)
	{
		if (p == null && q == null)
			return true;
		if (p == null)
			return false;
		if (q == null)
			return false;
		Queue<TreeNode> queue1 = new LinkedList();
		Queue<TreeNode> queue2 = new LinkedList();
		queue1.offer(p);
		queue2.offer(q);
		while (!queue1.isEmpty())
		{
			int size = queue1.size();
			for (int i = 0; i < size; i++)
			{
				TreeNode currentNode1 = queue1.poll();
				TreeNode currentNode2 = queue2.poll();
				if (currentNode1.key != currentNode2.key)
					return false;
				if (currentNode1.left == null && currentNode2.left != null)
					return false;
				if (currentNode2.left == null && currentNode1.left != null)
					return false;
				if (currentNode1.right == null && currentNode2.right != null)
					return false;
				if (currentNode2.right == null && currentNode2.right != null)
					return false;
				if (currentNode1.left != null)
					queue1.offer(currentNode1.left);
				if (currentNode2.left != null)
					queue2.offer(currentNode2.left);
				if (currentNode1.right != null)
					queue1.offer(currentNode1.right);
				if (currentNode2.right != null)
					queue2.offer(currentNode2.right);
				if (queue1.isEmpty() && !queue2.isEmpty())
					return false;
				if (queue2.isEmpty() && !queue1.isEmpty())
					return false;
			}
		}
		return true;
	}

	static int maxDepthValue = Integer.MIN_VALUE;
	static int currentDepth = 0;

	static int maxDepth(TreeNode root)
	{
		if (root == null)
			return 0;

		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		if (leftDepth > rightDepth)
			return leftDepth + 1;
		return rightDepth + 1;
	}

	//Finding diameter of a Binary Tree

	public static int diameter(TreeNode root)
	{
		if (root == null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		int leftDiameter = height(root.left);
		int rightDiameter = height(root.right);
		return Math.max((leftHeight + rightHeight), Math.max(leftDiameter, rightDiameter));
	}

	static int height(TreeNode root)
	{
		if (root == null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight);
	}

	//We will do this using DFS - Depth First
	static List<String> binaryTreePaths(TreeNode root)
	{
		List<String> result = new ArrayList<>();
		if (root == null)
			return result;
		String currentPath = Integer.toString(root.key);
		if (root.left == null && root.right == null)
			result.add(currentPath);
		if (root.left != null)
			dfs(root.left, currentPath, result);
		if (root.right != null)
			dfs(root.right, currentPath, result);
		return result;
	}

	static void dfs(TreeNode node, String currentPath, List<String> result)
	{
		currentPath += "->" + node.key;
		if (node.left == null && node.right == null)
		{
			result.add(currentPath);
		}
	}

	//Find the averages of levels in a binary tree
	static Queue<TreeNode> queueAverage = new LinkedList<>();

	public static List<Double> averageOfLevels(TreeNode root)
	{
		List<Double> averages = new ArrayList<>();
		queueAverage.offer(root);
		while (!queueAverage.isEmpty())
		{
			Double sum = 0.0;
			int size = queueAverage.size();
			for (int i = 0; i < size; i++)
			{
				TreeNode currentNode = queueAverage.poll();
				sum += currentNode.key;
				if (currentNode.left != null)
					queueAverage.offer(currentNode.left);
				if (currentNode.right != null)
					queueAverage.offer(currentNode.right);
			}
			averages.add(sum / size);
		}
		System.out.println("Averages:");
		averages.forEach(System.out::println);
		return averages;
	}

	/*
	You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.

	 */
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if(root1==null) return root2;
		if(root2==null) return root1;
		TreeNode root = new TreeNode(root1.key + root2.key);
		root.left = mergeTrees(root1.left, root2.left);
		root.right = mergeTrees(root1.right, root2.right);
		return root;
	}

	/*
	Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
	 */


	public static boolean sameTree(TreeNode p, TreeNode q) {
		//Check if both are equal to null. If yes, then its the same tree
		if(p == null && q == null) return true;
		/*
		The OR condition below when see in combination with the above statement will return true only when one of the nodes are null.
		This is because if both were null then the above AND condition itself would have got satisfied.
		 */
		if(p == null || q == null) return false;
		//Check if the values of the current nodes are equal
		if(p.key == q.key) {
			//Now if both the values are equal then check for the left and right subtrees recursively
			return sameTree(p.left, q.left) && sameTree(p.right, q.right);
		}
		else {
			//If the values are different in the current node itself, then no need to compare further. Return false from here itself
			return false;
		}
	}

	/*
	Alternate solution
	 public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p == null) return false;
        if(q == null) return false;
        Queue<TreeNode> queue1 = new LinkedList();
        Queue<TreeNode> queue2 = new LinkedList();
        queue1.offer(p);
        queue2.offer(q);
        while(!queue1.isEmpty()) {
            int size = queue1.size();
            for(int i=0;i<size;i++) {
                TreeNode currentNode1 = queue1.poll();
                TreeNode currentNode2 = queue2.poll();
                if(currentNode1.val != currentNode2.val) return false;
                if(currentNode1.left==null && currentNode2.left!=null) return false;
                if(currentNode2.left==null && currentNode1.left!=null) return false;
                if(currentNode1.right==null && currentNode2.right!=null) return false;
                if(currentNode2.right==null && currentNode2.right!=null) return false;
                if(currentNode1.left!=null) queue1.offer(currentNode1.left);
                if(currentNode2.left!=null) queue2.offer(currentNode2.left);
                if(currentNode1.right!=null) queue1.offer(currentNode1.right);
                if(currentNode2.right!=null) queue2.offer(currentNode2.right);
                if(queue1.isEmpty() && !queue2.isEmpty()) return false;
                if(queue2.isEmpty() && !queue1.isEmpty()) return false;
            }
        }
        return true;
    }
	 */

	/*
	Sum of Left Leaves
	Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
	 */
	public static int sumOfLeftLeaves(TreeNode root) {
		if(root == null) return 0;
		if(root.left!=null && root.left.left==null && root.left.right==null)
			return root.left.key + sumOfLeftLeaves(root.right);
		else
			return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}

	/*
	Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
	 */



	static List<Integer> list1 = new ArrayList<>();
	public static void findLeafSequence(TreeNode root) {
		if(root == null) return;
		if(root.left==null && root.right==null) {
			list1.add(root.key);
		}
		else {
			findLeafSequence(root.left);
			findLeafSequence(root.right);
		}
	}

	/*
	Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
	 */
	public static boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return isSymmetric(root.left,root.right);
	}

	public static boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left==null && right==null) return true;
		if(left==null || right ==null) return false;
		if(left.key != right.key) return false;
		if(!isSymmetric(left.left, right.right))
			return false;
		if(!isSymmetric(left.right, right.left))
			return false;
		return true;
	}
}