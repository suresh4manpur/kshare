package com.kshare.dlinklist;

class Node<K>{
	Node<K> next;
	Node<K> prev;
	K k;
	public Node(K k) {
		super();
		this.k = k;
	}
	
}