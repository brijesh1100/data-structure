package com.ds.algo.linklist;

import org.junit.Test;

public class SinglyCircularLinkedListTest {

	@Test
	public void testSinglyCircularLinkedList() {
		SinglyCircularLinkedList list = new SinglyCircularLinkedList();
		list.add(2);
		list.add(4);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(10);
		list.display();
		System.out.println();
		list.size();
	}

}
