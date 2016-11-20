package com.ds.algo.linklist;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add(1,"ddd");
		list.set(1,"gggg");
		System.out.println(list);
	}
}
