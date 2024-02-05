package com.ds.algo.dp.knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LIS {

	public List<Integer> lis(int[] arr) {
		List<Integer> list = new ArrayList<>();
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		return list;
	}

	public static void main(String[] args) {

		String arr = "ab-cddfdf";
		char[] str = arr.toCharArray();

		int r = str.length - 1, l = 0;

		// Traverse string from both ends until 'l' and 'r'
		while (l < r) {
			// Ignore special characters
			if (!Character.isAlphabetic(str[l]))
				l++;
			else if (!Character.isAlphabetic(str[r]))
				r--;

			// Both str[l] and str[r] are not spacial
			else {
				char tmp = str[l];
				str[l] = str[r];
				str[r] = tmp;
				l++;
				r--;
			}
		}
		System.out.println(new String(str));

	}
}
