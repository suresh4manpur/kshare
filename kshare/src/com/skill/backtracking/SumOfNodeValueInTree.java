package com.skill.backtracking;

public class SumOfNodeValueInTree {
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(11);
		root.right = new Node(2);

		root.left.left = new Node(8);
		root.left.right = new Node(9);

		root.right.left = new Node(7);
		root.right.right = new Node(8);
		int sum = sum(root);
		System.out.println("sum : " + sum);

	}

	private static int sum(Node current) {
		if (current == null)
			return 0;

		int sum = current.data;
		return sum + sum(current.left) + sum(current.right);
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		super();
		this.data = data;
	}

}
