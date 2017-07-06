package com.ds.algo.stack;

import org.junit.Test;

public class StackUsingLinkedListTest {

	@Test
	public void testStackUsingLinkedList() {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		stack.push(12);
		stack.push(34);
		stack.push(23);
		stack.push(56);
		stack.push(78);
		stack.push(54);
		stack.push(99);
		stack.display();
		stack.pop();
		stack.pop();
		stack.display();
	}

}
