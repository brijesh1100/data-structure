package com.ds.algo.dp.knapsack;

import java.util.Collections;
import java.util.Vector;

/**
 * Partition a set into two subsets such that the difference of subset sums is minimum
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the 
 * absolute difference between their sums is minimum.
 * If there is a set S with n elements, then if we assume Subset1 has m elements, 
 * Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 * 
 * Example:
 *  Input:  arr[] = {1, 6, 11, 5} 
 *  Output: 1
 *  Explanation:
 *  Subset1 = {1, 5, 6}, sum of Subset1 = 12 
 *  Subset2 = {11}, sum of Subset2 = 11  
 *  
 *  Will TopDown Approach from Dynamic programming
 * */

public class MinimumSubsetSumDiffWithTopDown {

	public static boolean mem_t[][];

	public static void main(String[] args) {
		int arr[] = { 1, 6, 5, 11 };
		int range = 0;
		for (int i = 0; i < arr.length; i++) {
			range = range + arr[i];
		}
		int n = arr.length;
		int W = range;
		mem_t = new boolean[n + 1][W + 1];
		initializeMem(n, W);
		boolean isTrue = subsetSum(arr, n, W);
		System.out.println(isTrue);
		Vector<Integer> vector = new Vector<Integer>();
		for (int i = 0; i < mem_t[n - 1].length / 2; i++) {
			if (mem_t[n - 1][i]) {
				vector.add(rangeVal(range, i));
			}
		}
		System.out.println("Minimum subsetsum diff: " + Collections.min(vector));

	}

	public static int rangeVal(int range, int val) {
		return (range - (2 * val));
	}

	private static void initializeMem(int n, int w) {
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

	private static boolean subsetSum(int[] arr, int n, int W) {
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
