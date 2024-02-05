package com.company.ps.round;

import java.util.ArrayList;
import java.util.List;

public class Check {

	static {
		System.out.println("sdjsdj");
	}
	public static void main(String[] args) {
		
		List<String> list1 = new ArrayList<>();
		list1.add("foo");
		List<String> list2 = list1;
		
		List<String> list3 = new ArrayList<>(list2);
		list1.clear();
		list2.add("bar");
		list3.add("baz");
		
		System.out.println(list1 + " "+ list2+ " "+ list3);
		
		System.out.println(Math.round(29.9));
	}
	
}
