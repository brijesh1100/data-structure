package com.ds.algo.dp.knapsack;

/**
 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the 
 * sum of elements in both subsets is the same.
 * arr[] = {1, 5, 11, 5}
 * Output: true 
 * The array can be partitioned as {1, 5, 5} and {11}
 * arr[] = {1, 5, 3}
 * Output: false 
 * The array cannot be partitioned into equal sum sets.
 * 
 * This class is implemented with TopDown approach
 * */
public class EqualSumPartitionTopDown {
	public static boolean mem_t[][];

	public static void main(String[] args) {
		int arr[] = { 3, 5, 13, 5 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		if (sum % 2 == 0) {
			int n = arr.length;
			int W = sum / 2;
			mem_t = new boolean[n + 1][W + 1];
			initializeTable(mem_t, n, W);
			boolean isTrue = subsetSumPartition(arr, n, W);
			System.out.println(isTrue);
		} else {
			System.out.println(false);
		}
	}

	private static void initializeTable(boolean[][] mem_t, int n, int w) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < w; j++) {
				if (i == 0) {
					mem_t[i][j] = false;
				}
				if (j == 0) {
					mem_t[i][j] = true;
				}
			}
		}
	}

	private static boolean subsetSumPartition(int[] arr, int n, int W) {

		if (n == 0) {
			return false;
		}
		if (W == 0) {
			return true;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < W + 1; j++) {
				if (arr[i - 1] <= j) {
					mem_t[i][j] = mem_t[i - 1][j - arr[i - 1]] || mem_t[i - 1][j];
				} else {
					mem_t[i][j] = mem_t[i - 1][j];
				}
			}
		}
		return mem_t[n][W];
	}

}
