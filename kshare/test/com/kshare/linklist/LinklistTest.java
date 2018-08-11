package com.kshare.linklist;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class LinklistTest {

	@Test
	public void addAtLastTest() {
		MyLinkList list = new MyLinkList();
		assertEquals(0, list.size);
		list.addAtLast(15);
		assertEquals(1, list.size);
		list.addAtLast(12);
		list.addAtLast(20);
		assertEquals(3, list.size);
		
		LinkedList<Integer> expextedList = new LinkedList<>();
		expextedList.add(15);
		expextedList.add(12);
		expextedList.add(20);
		
		for(int i=1 ; i <= expextedList.size() ; i++ ){
			assertEquals(expextedList.get(i-1), list.get(i));
		}
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void getEmptyListTest() {
		MyLinkList list = new MyLinkList();
		list.get(1);
	}
	@Test
	public void getNonEmptyListTest() {
		MyLinkList list = new MyLinkList();
		list.addAtLast(12);
		list.addAtLast(20);
		assertEquals(new Integer(20), list.get(2));
	}
	

}
