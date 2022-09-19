package com.ds.algo.dp.knapsack;

/**
 * Count of subset sum in given sum Given an array arr[] of length N and an
 * integer X, the task is to find the number of subsets with a sum equal to X.
 * 
 * nput: arr[] = {1, 2, 3, 3}, X = 6 Output: 3 
 * All the possible subsets are {1, 2, 3}, {1, 2, 3} and {3, 3}
 * 
 * Input: arr[] = {1, 1, 1, 1}, X = 1 Output: 4
 */
public class CountOfSubsetSumInGivenSum {

	public static int mem_t[][];

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 3 };
		int W = 6;
		int n = arr.length;

		mem_t = new int[n + 1][W + 1];

		initializeTable(mem_t, n, W);
		int count = 0;
		int result = countOfSubsetSum(arr, n, W, count);
		System.out.println(result);

	}

	private static void initializeTable(int[][] mem_t2, int n, int w) {
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				mem_t[i][j] = -1;
			}
		}
	}

	private static int countOfSubsetSum(int[] arr, int n, int w, int count) {
		if (n == 0 && w != 0) {
			return 0;
		}
		if (w == 0) {
			return 1;
		}
		if (mem_t[n][w] != -1) {
			return mem_t[n][w];
		}
		if (arr[n - 1] <= w) {
			return mem_t[n][w] = countOfSubsetSum(arr, n - 1, w - arr[n - 1], count)
					+ countOfSubsetSum(arr, n - 1, w, count);
		} else {
			return mem_t[n][w] = countOfSubsetSum(arr, n - 1, w, count);
		}
	}
}
