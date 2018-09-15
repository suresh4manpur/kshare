package com.kshare.dlinklist;

import org.junit.Test;
import static org.junit.Assert.*;
public class DoublyLinkedListTest {

	@Test(expected = Exception.class)
	public void insertBeforeForEmpty() throws Exception {
		DoublyLinkedList<Integer> dList = new DoublyLinkedList<>();
		assertEquals(0, dList.size);
		dList.insertBefore(1, 2);
	}
	@Test
	public void insertBeforeSuccess() throws Exception {
		DoublyLinkedList<Integer> dList = new DoublyLinkedList<>();
		dList.insertFirst(1);
		dList.insertBefore(2, 1);
		assertEquals(2, dList.size);
		Node<Integer> current = dList.header;
		assertEquals(new Integer(2), (Integer)current.k);
		dList.insertBefore(3, 1);
		current = dList.header;
		assertEquals(new Integer(3), (Integer)current.next.k);
		dList.insertBefore(4, 1);
		current = dList.header;
		assertEquals(4, dList.size);
		assertEquals(new Integer(4), (Integer)current.next.next.k);

	}
	// 2 -->1, 2 -->3 -->1
	@Test
	public void insertFirstTest(){
		DoublyLinkedList<Integer> dList = new DoublyLinkedList<>();
		dList.insertFirst(1);
		assertEquals(1, dList.size);
		assertEquals(new Integer(1), (Integer)dList.header.k);
		dList.insertFirst(2);
		assertEquals(2, dList.size); 
		Node<Integer> current = dList.header;
		assertEquals(new Integer(2), (Integer)current.k);
	}
	@Test(expected = Exception.class)
	public void testRemoveEmpty() throws Exception{
		DoublyLinkedList<Integer> dList = new DoublyLinkedList<>();
		dList.remove(2);
	}
	@Test
	public void testRemoveSuccess() throws Exception{
		DoublyLinkedList<Integer> dList = new DoublyLinkedList<>();
		dList.insertFirst(1);
		dList.insertFirst(2);
		dList.insertFirst(3);
		dList.insertFirst(4);
		dList.showList();
		dList.remove(4); //Remove first
		assertEquals(3, dList.size);
		dList.showList();
		dList.remove(2);//remove in b/w
		dList.showList();
		dList.insertFirst(5);
		dList.insertFirst(6);
		dList.showList();
		dList.remove(1);//remove last
		dList.showList();

	}

}
