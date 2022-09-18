package com.ds.algo.dp.knapsack;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is
 * a subset of the given set with sum equal to given sum. Input: set[] = {3, 34,4, 12, 5, 2}, 
 * sum = 9 Output: True There is a subset (4, 5) with sum 9.
 * 
 * Will use recursion + memoization to solve this.
 */
public class SubSetSumProblem {
	public static int W;
	public static int n;
	public static int mem_t[][];

	/**
	 * Recursion
	 */
	public static boolean subSetSum(int wt[], int n, int w) {

		if (n == 0 & w!=0) {
			return false;
		}
		if (w == 0) {
			return true;
		}
		if (mem_t[n][w] != -1) {
			return mem_t[n][w] == 1;
		}
		if (wt[n - 1] > w) {
			return subSetSum(wt, n - 1, w);
		} else {
			if(subSetSum(wt, n - 1, w - wt[n - 1]) || subSetSum(wt, n - 1, w)) {
				return true;
			}else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12 };
		int sum = 7;
		W = sum;
		n = set.length;
		mem_t = new int[n + 1][W + 1];
		initializeMemTable(mem_t, n, W);
		boolean ans = subSetSum(set, set.length, sum);
		System.out.println(ans);
	}

	private static void initializeMemTable(int[][] mem_t, int n, int w) {
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				mem_t[i][j] = -1;
			}
		}
	}
}
