package com.ds.algo.linklist;

import org.junit.Test;

public class SinglyLinkedListTest {

	@Test
	public void testAdd() {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(5);
		list.add(7);
		list.add(4);
		list.add(34);
		list.add(12);
		list.add(6);
		list.display();
	}

}
