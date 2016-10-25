package com.ds.algo.linklist;

import org.junit.Test;

public class DoublyCircularLinkedListTest {

	@Test
	public void test() {
		DoublyCircularLinkedList list= new DoublyCircularLinkedList();
		list.add(34);
		list.add(3);
		list.add(24);
		list.add(5);
		list.add(7);
		list.add(78);
		list.display();
	}

}
