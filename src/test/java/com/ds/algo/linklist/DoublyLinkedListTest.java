package com.ds.algo.linklist;

import org.junit.Test;

public class DoublyLinkedListTest {

	@Test
	public void testDoublyLinkedList() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(2);
		list.add(55);
		list.add(34);
		list.add(5);
		list.display();
	}

}
