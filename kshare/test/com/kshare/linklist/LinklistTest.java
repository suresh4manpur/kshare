package com.kshare.linklist;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinklistTest {

	@Test
	public void addElementTest() {
		MyLinkList list = new MyLinkList();
		assertEquals(0, list.size);
		list.addAtLast(15);
		assertEquals(1, list.size);
	}

}
