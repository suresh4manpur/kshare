package com.kshare.tree;

public class BinarySearchTree {

	public static Node root;

	public BinarySearchTree() {

		this.root = null;

	}

	public boolean find(int id) {

		Node current = root;

		while (current != null) {

			if (current.data == id) {

				return true;

			} else if (current.data > id) {

				current = current.left;

			} else {

				current = current.right;

			}

		}

		return false;

	}

	/*
	 * public boolean delete(int id){
	 * 
	 * Node parent = root;
	 * 
	 * Node current = root;
	 * 
	 * boolean isLeftChild = false;
	 * 
	 * while(current.data!=id){
	 * 
	 * parent = current;
	 * 
	 * if(current.data>id){
	 * 
	 * isLeftChild = true;
	 * 
	 * current = current.left;
	 * 
	 * }else{
	 * 
	 * isLeftChild = false;
	 * 
	 * current = current.right;
	 * 
	 * }
	 * 
	 * if(current ==null){
	 * 
	 * return false;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * //if i am here that means we have found the node
	 * 
	 * //Case 1: if node to be deleted has no children
	 * 
	 * if(current.left==null && current.right==null){
	 * 
	 * if(current==root){
	 * 
	 * root = null;
	 * 
	 * }
	 * 
	 * if(isLeftChild ==true){
	 * 
	 * parent.left = null;
	 * 
	 * }else{
	 * 
	 * parent.right = null;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * //Case 2 : if node to be deleted has only one child
	 * 
	 * else if(current.right==null){
	 * 
	 * if(current==root){
	 * 
	 * root = current.left;
	 * 
	 * }else if(isLeftChild){
	 * 
	 * parent.left = current.left;
	 * 
	 * }else{
	 * 
	 * parent.right = current.left;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * else if(current.left==null){
	 * 
	 * if(current==root){
	 * 
	 * root = current.right;
	 * 
	 * }else if(isLeftChild){
	 * 
	 * parent.left = current.right;
	 * 
	 * }else{
	 * 
	 * parent.right = current.right;
	 * 
	 * }
	 * 
	 * }else if(current.left!=null && current.right!=null){
	 * 
	 * 
	 * 
	 * //now we have found the minimum element in the right sub tree
	 * 
	 * Node successor = getSuccessor(current);
	 * 
	 * if(current==root){
	 * 
	 * root = successor;
	 * 
	 * }else if(isLeftChild){
	 * 
	 * parent.left = successor;
	 * 
	 * }else{
	 * 
	 * parent.right = successor;
	 * 
	 * }
	 * 
	 * successor.left = current.left;
	 * 
	 * }
	 * 
	 * return true;
	 * 
	 * }
	 */

/*	public Node getSuccessor(Node deleleNode) {

		Node successsor = null;

		Node successsorParent = null;

		Node current = deleleNode.right;

		while (current != null) {

			successsorParent = successsor;

			successsor = current;

			current = current.left;

		}

		// check if successor has the right child, it cannot have left child for
		// sure

		// if it does have the right child, add it to the left of
		// successorParent.

		// successsorParent

		if (successsor != deleleNode.right) {

			successsorParent.left = successsor.right;

			successsor.right = deleleNode.right;

		}

		return successsor;

	}*/

	public void insert(int id) {

		Node newNode = new Node(id);

		if (root == null) {

			root = newNode;

			return;

		}

		Node current = root;

		Node parent = null;

		while (true) {

			parent = current;

			if (id < current.data) {

				current = current.left;

				if (current == null) {

					parent.left = newNode;

					return;

				}

			} else {

				current = current.right;

				if (current == null) {

					parent.right = newNode;

					return;

				}

			}

		}

	}

	public boolean delete(int data) {

		Node current = root;
		Node parent = root;
		Node keyNode = new Node(data);
		
		boolean isLeftChild = false;
		//1 find the deleting node
		while (current != null) {
			if (current.data != keyNode.data) {
				parent = current;
				if (keyNode.data > current.data) {
					current = current.right;
					isLeftChild = false;
				} else {
					current = current.left;
					isLeftChild = true;
				}

			} else {
				break;
			}
		}
		if (current == null) {
			return false;
		}
		// 2. Deleting node is leaf node

		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
				return true;
			}
			if (isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			
		}
		// 3. Deleting node is having two child nodes.
		// Deleting elements
		// Successor
		// Successor's parent element
		// Child of successor
		else if( current.left != null && current.right != null){
			Node deletingNode = current;
			Node successor = null;
			Node successorParent = null;
			//get Successor element
			successor = getSuccessor(deletingNode,successorParent);
			current.data = successor.data;
			
		}
		// 4. Deleting node is having one child node only
		else{
			if (current == root) {
				if (current.left != null) {
					root = current.left;
				} else {
					root = current.right;
				}
			}
			if (isLeftChild) {

				if (current.left != null) {
					parent.left = current.left;
				} else {
					parent.left = current.right;
				}

			} else {

				if (current.left != null) {
					parent.right = current.left;
				} else {
					parent.right = current.right;
				}
			}
		}

		return false;
	}
	public Node getSuccessor(Node deletingNode , Node successorParent){
		//Min value of right sub tree of deleting element
		//Assumption - deletingNode will never be null
		Node current = deletingNode.right;
		successorParent = current;
		while(current != null && current.left != null){
			successorParent = current;
			current = current.left;
		}
		if(current.right != null){
			successorParent.left = current.right;
		}
		return current;
	}

	public void display(Node root) {
		// In-order traversal
		// Post-Order Traversal
		// Pre-order Traversal

		if (root != null) {

			display(root.left);

			System.out.print(" " + root.data);

			display(root.right);

		}

	}

	public static void main(String arg[]) {

		BinarySearchTree b = new BinarySearchTree();

		b.insert(3);
		b.insert(8);

/*		b.insert(1);
		b.insert(4);
		b.insert(6);
		b.insert(2);
		b.insert(10);
		b.insert(9);

		b.insert(20);
		b.insert(25);
		b.insert(15);
		b.insert(16);*/

		System.out.println("Original Tree : ");

		b.display(b.root);

		System.out.println("");

		System.out.println("Check whether Node with value 4 exists : " + b.find(4));

		
		  b.delete(3);
	
		  /*
		   b.delete(4);

		   b.delete(10);
		 */

		 

		b.display(root);

	}

}
