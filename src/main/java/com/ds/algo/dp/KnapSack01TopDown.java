package com.ds.algo.dp;

public class KnapSack01TopDown {
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

	private static int knapsack(int[] wt, int[] val, int w, int n) {
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < w+1; j++) {
				if(i==0 || j==0) {
					mem_t[i][j]=0;
				}else if(wt[i-1]<=j) {
					mem_t[i][j]=max((val[i-1] + mem_t[i-1][j-wt[i-1]]), mem_t[i-1][j]);
				}else {
					mem_t[i][j]=mem_t[i-1][j];
				}
			}
		}
		return mem_t[n][w];
	}

}
