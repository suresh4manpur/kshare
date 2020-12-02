package com.kshare.google.tree;

public class BinaryTreeFromPreOrderAndInOrderArray {
	Node root;
	
	int[] io;
	int[] po;
	
	public BinaryTreeFromPreOrderAndInOrderArray(int[] io, int[] po) {
		this.io = io;
		this.po = po;
	}

	public Node buildTree(int ioStart, int size){
		
		//int index = findIndex
		return null;
	}
	public int findIndex( int startPos){
		return po[startPos];
	}
}
