package com.ds.algo.dp.matrics;

import java.util.ArrayList;
import java.util.List;

public class SpriralMatrix {

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
		getSpiralMatrix();
		System.out.println(list);
	}

	public static List<Integer> getSpiralMatrix() {
		int top = 0, down = matrix[1].length - 1, left = 0, right = matrix.length - 1;
		while (top <= down && left <= right) {
			for (int i = left; i <= right; i++) {
				list.add(matrix[left][i]);
			}
			top++;
			for (int i = top; i <= down; i++) {
				list.add(matrix[i][right]);
			}
			right--;
			if (top <= down) {
				for (int i = right; i >= left; i--) {
					list.add(matrix[down][i]);
				}
				down--;
			}
			if (left <= right) {
				for (int i = down; i >= top; i--) {
					list.add(matrix[i][left]);
				}
				left++;
			}
		}

		return list;
	}

	private static boolean checkRistrictiveBoundary(int[] pos) {
//		int top=0,down=N-1
		int row = pos[0];
		int col = pos[1];
		if (row <= matrix.length && col <= matrix[1].length) {
			return true;
		}
		return false;
	}

	private static boolean isVisisted(int[] pos) {
		if (visitedPositions.contains(pos)) {
			return true;
		} else {
			visitedPositions.add(pos);
			return false;
		}

	}
}
