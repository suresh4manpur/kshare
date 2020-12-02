package com.kshare.google.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree {
	Queue<Node> q = new ArrayDeque<>();
	Node root ;

	public static void main(String[] args) {
		CompleteBinaryTree bt = new CompleteBinaryTree();
		for(int i=1; i<=10 ;i++){
			bt.insert(i);
		}
		
		bt.levelOrder();
  	}
	public void insert(int data){
		Node current = null;
		Node temp = null;
		if(q.size() == 0){
			root = new Node(data);
			q.add(root);
		}else{
			current = q.peek();
			if(current.left == null){
				temp = new Node(data);
				q.add(temp);
				current.left = temp;
			}
			else  if(current.right == null){
				q.remove();
				temp =new Node(data);
				q.add(temp);
				current.right = temp;
			}
		}		
	}
	public void levelOrder(){
		Node current = root;
		System.out.println(" root : "+root.data);
		q.clear();
		if(root != null){
			q.add(root);
		}
		
		while(q.size() > 0){
			current = q.remove();
			if(current != null){
				System.out.print(" "+current.data);
			}
			if(current.left != null){
				q.add(current.left);
			}
			if(current.right != null){
				q.add(current.right);
			}
		}
		
	}
}
