package com.kshare.google.tree;

public class BFSTraversal {
	public static void main(String[] args) {

		Node root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(60);
		root.left.left = new Node(25);
		root.left.right = new Node(32);
		root.right.left = new Node(55);
		root.right.right = new Node(65);

		BFSTraversal bfsTraversal = new BFSTraversal();

		System.out.println("Preorder traversal");
		bfsTraversal.preOrder(root);
		System.out.println("PostOrder traversal");
		bfsTraversal.postOrder(root);
		System.out.println("InOrder traversal");
		bfsTraversal.inOrder(root);
	}

	private void preOrder(Node root) {

		if (root == null) {
			return;
		}
		Node current = root;
		if (current != null) {
			System.out.println(current.data);
			preOrder(current.left);
			preOrder(current.right);
		}
	}

	private void inOrder(Node current) {

		if (current == null) {
			return;
		}
		inOrder(current.left);
		System.out.println(current.data);
		inOrder(current.right);

	}

	private void postOrder(Node current) {
		// Base case
		if (current == null) {
			return;
		}
		//recursive case
		postOrder(current.left);
		postOrder(current.right);
		System.out.println(current.data);

	}

}
