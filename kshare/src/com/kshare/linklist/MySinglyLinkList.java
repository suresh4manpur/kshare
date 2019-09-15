package com.kshare.linklist;

public class MySinglyLinkList {
	public static void main(String[] args) {
		MyLinkList list = new MyLinkList();

		list.addAtLast(6);
		list.addAtLast(7);
		list.addAtLast(8);
		list.addAtLast(9);
		// 6 7 8 9
		// 10 before 7
		list.addBefore(10, 7);
		list.addBefore(11, 100); // Bug

		/*
		 * list.addAtLast(1); list.addBefore(10, 1);
		 */
		list.show();
		list.remove(7);
		list.show();
		

	}
}

class Node {
	int data;
	Node next;

	public Node(int data) {
		super();
		this.data = data;
	}

}

class MyLinkList {
	Node first;
	int size;

	public void addAtLast(int data) {
		Node newnode = new Node(data);

		if (isListEmpty()) {
			first = newnode;
		} else {
			// traverse and go till last and get the last element.
			Node current = first;
			while (current.next != null) {
				current = current.next;
			}
			// current --> last element
			current.next = newnode;
		}
		size++;
	}

	public void addBefore(int srcNode, int destNode) {
		Node current = first;
		Node newnode = new Node(srcNode);
		if (isListEmpty()) {
			return;
		}
		if (first.next == null && first.data == destNode) {
			newnode.next = first;
			first = newnode;
		} else {
			while (current.next != null) {
				if (current.next.data == destNode) {
					break;
				}
				current = current.next;
			}
			if (current.next != null && current.next.data == destNode) {
				newnode.next = current.next;
				current.next = newnode;
			}

		}
		size++;
		// First -->A --> B --> C | D before B A --> D -->B --> C
	}

	public void addtAfter(int src, int dest) {

	}

	public Integer get(int index) {
		if (index > size)
			throw new IndexOutOfBoundsException();
		Node current = first;
		while (index > 1) {
			current = current.next;
			index--;
		}
		return current.data;
	}

	public void show() {
		StringBuffer strBuf = new StringBuffer();

		Node current = first;
		while (current != null) {
			strBuf.append(" " + current.data);
			current = current.next;
		}
		System.out.println(strBuf.toString());
	}

	public boolean isListEmpty() {
		if (first == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean remove(int k) {
		if (isListEmpty()) {
			throw new RuntimeException("list is empty!");
		}
		Node current = first;
		boolean result = false;

		// 1. first element
/*		while(current!= null){
			
		}*/
		if (first.data > k) {
			current = current.next;
			first.next = null;
			first = current;
		} else {
			Node prev = current;
			current = current.next;

			while (current != null && current.data != k) {
				prev = current;
				current = current.next;
			}

			// did not match
			if (current == null) {
				result = false;
			} else {
				// matched
				// 2. last element
				if (current.next == null) {
					prev.next = null;

				} else {
					// 3. mid element
					prev.next = null;
					Node temp = current.next;
					current.next = null;
					prev.next = temp;

				}
				size--;
				result = true;
			}

		}

		return result;
	}

}
