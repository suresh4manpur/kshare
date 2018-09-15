package com.kshare.dlinklist;

public class DoublyLinkedList<K> {

	Node<K> header;
	int size;
	public void showList(){
		Node<K> current = header;
		while(current != null){
			System.out.print(current.k+"-->");
			current = current.next;
		}
		System.out.println("");
	}
	//Newnode --> 2 --> 1
	public void insertFirst(K k){
		Node<K> newnode = new Node<K>(k);
		if(header != null){
			newnode.next = header;
			header.prev = newnode;
		}
		header = newnode;	
		size++;
	}
	public void remove(K target) throws Exception{
		if(isEmpty()){
			throw new Exception("List is empty.");
		}
		Node<K> current = header;
		while(current != null && current.k != target){
			current = current.next;
		}
		if(current == null){
			throw new Exception("Target not found.");
		}
		if(current == header){
			current = current.next;
			header = current;
		}else if(current.next == null){
			current.prev.next = null;
		}else{
			current.prev.next = current.next;
			current.next.prev = current.prev;
			current.next = null;
		}
		current.prev = null;
		size--;
	}
	/*
	 *  1. empty
	 *  2. removing first element
	 *  3. removing last element
	 *  4. removing in between
	 *  5. Target not found
	 *  
	 *   2--> 3--> 1
	 *   2<-- 3<-- 1
	 *  
	 */
	public boolean isEmpty(){
		if(header == null){
			return true;
		}else{
			return false;
		}
	}
	public void insertBefore( K k, K target) throws Exception{
		Node<K> newnode = new Node<K>(k);
		Node<K> current = header;
		Node<K> previous = null;
		if(size == 0){ //if empty
			throw new Exception("List is empty.");
		}
		else{
			while(current!= null && current.k != target){ // find the position
				previous = current; 
				current = current.next;
				/* previous = current; */
			}
			if(current.k == target){
				if(size == 1){ // having only one element
					header = newnode;
				}else{ // 
					newnode.prev = previous;
					previous.next = newnode;
				}
				newnode.next = current;
				current.prev = newnode;
				size++;
				return;
			}
				
		}
		
	}


}
