package com.ds.algo.dp.matrics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaxPathSumMatrix {

	public static int[][] matrix;
	public static List<int[]> visitedPositions = new ArrayList<>();
	public static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		int N = 4, M = 4; // N=row, M=col;
		matrix = new int[N][M];
		int[][] arr = { { 1, 2, 3, 4 }, 
						{ 5, 6, 7, 8 }, 
						{ 9, 10, 11, 12 }, 
						{ 13, 14, 15, 16 } };
		matrix = arr;
		getMaxSumPath(0,0);
//		1->5->9-10->11->15->16
	}

	private static void getMaxSumPath(int i, int j) {
		int top = 0, left = 0, right = matrix.length, bottom = matrix[1].length;
		
//		while(top<=bottom && left<=right) {
//			
//		}
		
		
		
	}

	
}
