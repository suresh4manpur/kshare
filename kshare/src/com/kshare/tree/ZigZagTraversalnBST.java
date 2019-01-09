package com.kshare.tree;

import java.util.Stack;

public class ZigZagTraversalnBST {
	
	Stack<Node> s1 = new Stack<>();
	Stack<Node> s2 = new Stack<>();
	boolean isLeft = true;
	Node current = null;
	
	public void traverse(Node root) {
		
		// two stack
		// boolean left;
		
		s1.push(root);
		current = root;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			// repeat reading and pushing and printing element for both stack
			while (!s1.isEmpty()) {

				// reads children of node from first stack and push to 2nd stack
				// and then print the value
				
				doZigZagTraversalProcess(s2, s1);
			}
			while (!s2.isEmpty()) {
				// reads children of node from 2nd stack and push to 1st stack
				// and then print the value.

				// reads children of node from first stack and push to 2nd stack
				// and then print the value
				
				doZigZagTraversalProcess(s1,s2);
			}
		}
	}
	public void doZigZagTraversalProcess(Stack<Node> s1, Stack<Node> s2){
		current = s2.pop();

		if(current != null){
			
			System.out.println(" "+current.data);
			
			if (isLeft) {
				s1.push(current.left);
				s1.push(current.right);
			} else {
				s1.push(current.right);
				s1.push(current.left);
			}
			if (s2.isEmpty()) {
				isLeft = !isLeft;
			}
			
		}
	}
}
