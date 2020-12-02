package com.kshare.google.tree;

public class ConvertBST_to_SingleLinkedList {
	public static void main(String[] args) {

		Node root1 = new Node(50);
		root1.left = new Node(30);
		root1.right = new Node(60);
		root1.left.left = new Node(25);
		root1.left.right = new Node(32);
		root1.right.left = new Node(55);
		root1.right.right = new Node(65);
		
		Node root2 = new Node(15);
		root2.left = new Node(8);
		root2.right = new Node(20);
		root2.left.left = new Node(5);
		root2.left.right = new Node(9);
		root2.right.left = new Node(19);
		root2.right.right = new Node(35);

		ConvertBST_to_SingleLinkedListImpl converter = new ConvertBST_to_SingleLinkedListImpl();
		Link head1 = converter.convertBSTtoLInkedList(root1);
		Link head2 = converter.convertBSTtoLInkedList(root2);
		

		traverseLinkedList(head1);
		
		System.out.println("");
		
		traverseLinkedList(head2);
		
		System.out.println("");

		System.out.println("Sorted Merged linked list");
		Link mergedHead = converter.mrgeLInkedList(head1, head2);
		
		traverseLinkedList(mergedHead);


	}

	private static void traverseLinkedList(Link head) {
		Link current = head;
		while(current != null) {
			System.out.print(" "+current.data);
			current = current.next;
		}
		
	}



}
class ConvertBST_to_SingleLinkedListImpl{
	Link current ;

	public Link convertBSTtoLInkedList(Node root) {
		current = new Link(-1);
		Link head = current;
		if(root == null) {
			return null;
		}
		 inOrder(root);
		 return head.next;

	}
	private void inOrder(Node root) {
		if(root == null) {
			return ;
		}
		if(root.left != null) {
			inOrder(root.left);
		}
		current.next = new Link(root.data);
		current = current.next;
		
		if(root.right != null) {
			inOrder(root.right);
		}
		
	}
	public Link mrgeLInkedList(Link head1, Link head2){
		
		Link head = new Link(-1);
		current = head;
		
		Link current1 = head1;
		Link current2 = head2;
		
		while(current1 != null && current2 != null) {
			if(current1.data < current2.data) {
				current.next = new Link(current1.data);
				current1 = current1.next;
			}else {
				current.next = new Link(current2.data);
				current2 = current2.next;
			}
			current = current.next;

		}
		while(current1 != null) {
			current.next = new Link(current1.data);
			current = current.next;
			current1 = current1.next;
		}
		while(current2 != null) {
			current.next = new Link(current2.data);
			current = current.next;
			current2 = current2.next;
		}
		return head.next;
	}
}
