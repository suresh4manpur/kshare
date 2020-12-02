package com.kshare.google.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSTraversal {
	public static void main(String[] args) {
		DFSTraversal bfsClass = new DFSTraversal();
		Node root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(60);
		root.left.left = new Node(25);
		root.left.right = new Node(32);
		root.right.left = new Node(55);
		root.right.right = new Node(65);

		bfsClass.bfsTraversal(root);
	}

	private void bfsTraversal(Node root) {
		Queue<Node> que = new LinkedList<Node>();

		if (root != null) {
			que.add(root);
		}
		while (que.size() > 0) {
			Node current = que.remove();
			System.out.println(" " + current.data);
			if (current.left != null) {
				que.add(current.left);
			}

			if (current.right != null) {
				que.add(current.right);
			}
		}
	}


}
