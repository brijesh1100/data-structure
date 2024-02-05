package com.company.ps.round;

import java.util.ArrayList;
import java.util.List;

public class AIDashClazz {

	public static List<Integer> roundTable(int N, int[] pass, int K ){
		
		List<Integer> roundTable = new ArrayList<>();
		for (int i = 1; i < N+1; i++) {
			roundTable.add(i);
		}
		List<Integer> allRemovedPeopel =  new ArrayList<>();
		int startPos = 0;
		int endPos = 0;
		
		for (int i = 0; i < K; i++) {
			endPos = (pass[i] % N) + endPos;
			if(endPos==N) {
				endPos = 0;
			}
			allRemovedPeopel.add(roundTable.get(endPos));
			startPos = endPos + 1;
			endPos = startPos;
		}
		return allRemovedPeopel;
	} 
	
//	pass 8,1,1
	
	public static void main(String[] args) {
		int[] pass = {3,1,1};
		int N=7;
		int K = 3;
//		We need not to remove the layout just index capture
		List<Integer> allRemovedPeopel = roundTable(N, pass,K);
		System.out.println(allRemovedPeopel);
	}
}
