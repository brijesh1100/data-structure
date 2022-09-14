package com.ds.algo.dp;

/**
 * This code is based on pure recursion.
 * Memoization(Bottom-up) is not been used in this.
 * */
public class KnapSack01 {
	
//	int K[][]=
	
	static int max(int a, int b) {
		return (a > b) ? a : b;
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
//		Choice diagram
		if (w[n - 1] > W) {
			return knapsack(w, val, W, n - 1);
		} else {
			return max(val[n - 1] + knapsack(w, val, W - w[n - 1], n - 1), knapsack(w, val, W, n - 1));
		}
	}

	public static void main(String[] args) {
		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };

		int W = 50;
		int N = val.length;

		System.out.println(knapsack(wt, val, W, N));
	}

}
