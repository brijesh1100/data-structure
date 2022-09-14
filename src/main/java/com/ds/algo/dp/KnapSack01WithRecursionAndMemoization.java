package com.ds.algo.dp;

/**
 * Recursion + Memoization = Dynamic Programming, you do not need to write Top-down approach
 * The time complexity would be same in both the case.
 * */
public class KnapSack01WithRecursionAndMemoization {
//	This I initialize size needs to change n+1, W+1
	public static int mem_t[][] = new int[4][51];
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}


	public static void main(String[] args) {
		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };

		int W = 50;
		int N = val.length;
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < W+1; j++) {
				mem_t[i][j] = -1;
			}
		}
		System.out.println(mem_t[0][1]);

		System.out.println(knapsack(wt, val, W, N));
	}

	/**
	 * In order to perform knapsack follow 2 important rule.
	 * 1. Recursion and 2.Memoization
	 * Now for recursion u need to follow 2 important thing
	 * 1. Base condition and 2. Choice diagram 
	 * */
	static int knapsack(int w[], int val[], int W, int n) {
//		Base condition
		if (W == 0 || n == 0) {
			return 0;
		}
		if(mem_t[n][W]!=-1) {
			return mem_t[n][W];
		}
//		Choice diagram
		if (w[n - 1] > W) {
			mem_t[n][W] = knapsack(w, val, W, n - 1);
			return mem_t[n][W];
		} else {
			mem_t[n][W] = max(val[n - 1] + knapsack(w, val, W - w[n - 1], n - 1), knapsack(w, val, W, n - 1));
			return mem_t[n][W];
		}
		
	}
}
