package com.ds.algo.stack;

import org.junit.Test;

public class StackUsingArrayTest {

	@Test
	public void testStackUsingArray() {
		StackUsingArray stack = new StackUsingArray(5);
		stack.push(23);
		stack.push(33);
		stack.push(35);
		stack.push(78);
		stack.push(90);
		stack.pop();
		System.out.println(stack);
	}

}
