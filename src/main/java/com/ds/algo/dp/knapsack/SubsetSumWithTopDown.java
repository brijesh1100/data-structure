package com.ds.algo.dp.knapsack;

public class SubsetSumWithTopDown {

	public static int W;
	public static int n;
	public static boolean mem_t[][];

	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12 };
		int sum = 7;
		W = sum;
		n = set.length;
		mem_t = new boolean[n + 1][W + 1];
		initializeMemTable(mem_t, n, W);
		boolean isSubsetSumPresent = subsetSum(set, n, W);
		System.out.println(isSubsetSumPresent);
	}

	private static boolean subsetSum(int[] arr, int n, int W) {
		if (n == 0) {
			return false;
		}
		if (W == 0) {
			return true;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				System.out.println(i + ", " + j);
				if (arr[i - 1] <= j) {
					mem_t[i][j] = mem_t[i - 1][j - arr[i - 1]] || mem_t[i - 1][j];
				} else {
					mem_t[i][j] = mem_t[i - 1][j];
				}
			}
		}
		return mem_t[n][W];

	}

	private static void initializeMemTable(boolean[][] mem_t, int n, int w) {
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

}
