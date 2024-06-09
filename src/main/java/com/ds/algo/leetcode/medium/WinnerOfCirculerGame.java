package com.ds.algo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * There are n friends that are playing a game. The friends are sitting in a circle and are numbered 
 * from 1 to n in clockwise order. More formally, moving clockwise from the ith friend brings you to 
 * the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.
 * */
public class WinnerOfCirculerGame {

	public static int findTheWinner(int n, int k) {
		
		List<Integer> roundTable = new ArrayList<>();
		for (int i = 1; i < n+1; i++) {
			roundTable.add(i);
		}
		int startPos = 0;
		int endPos = 0;
		
		while(n>=1) {
			endPos = startPos+k;
//			roundTable.remove(endPos);
			startPos = endPos + 1;
			endPos = startPos;
			n--;
			if (endPos >= roundTable.size()) {
				endPos = 0;
			}
		}
		System.out.println(endPos);
		
//		for (int i = 0; i < K; i++) {
//			endPos = (pass[i] % N) + endPos;
//			if(endPos==n) {
//				endPos = 0;
//			}
//			allRemovedPeopel.add(roundTable.get(endPos));
//			startPos = endPos + 1;
//			endPos = startPos;
//		}
		
		
		
		return roundTable.get(0);
	}
	
	public static void main(String[] args) {
		System.out.println(findTheWinner(5, 2));
	}
}
