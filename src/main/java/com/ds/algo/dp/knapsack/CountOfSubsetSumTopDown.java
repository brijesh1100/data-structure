package com.ds.algo.dp.knapsack;

/**
 * Count of subset sum in given sum Given an array arr[] of length N and an
 * integer X, the task is to find the number of subsets with a sum equal to X.
 * 
 * nput: arr[] = {1, 2, 3, 3}, X = 6 Output: 3 
 * All the possible subsets are {1, 2, 3}, {1, 2, 3} and {3, 3}
 * 
 * Input: arr[] = {1, 1, 1, 1}, X = 1 Output: 4
 * 
 * With TopDown approach
 */
public class CountOfSubsetSumTopDown {

	public static int mem_t[][];

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 3 };
		int W = 6;
		int n = arr.length;
		mem_t = new int[n + 1][W + 1];
		initializeTable(mem_t, n, W);
		int result = countOfSubsetSum(arr, n, W);
		System.out.println(result);

	}

	private static int countOfSubsetSum(int[] arr, int n, int w) {
		if (n == 0) {
			return 0;
		}
		if (w == 0) {
			return 1;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				if (arr[i - 1] <= j) {
					mem_t[i][j] = mem_t[i - 1][j - arr[i - 1]] + mem_t[i - 1][j];
				} else {
					mem_t[i][j] = mem_t[i - 1][j];
				}
			}
		}
		return mem_t[n][w];
	}

	private static void initializeTable(int[][] mem_t, int n, int w) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < w; j++) {
				if (i == 0) {
					mem_t[i][j] = 0;
				}
				if (j == 0) {
					mem_t[i][j] = 1;
				}
			}
		}
	}

}
