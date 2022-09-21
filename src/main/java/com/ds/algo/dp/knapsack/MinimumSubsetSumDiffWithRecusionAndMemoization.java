package com.ds.algo.dp.knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
 *  Will use Recursion + Memoization
 * */
public class MinimumSubsetSumDiffWithRecusionAndMemoization {

	public static boolean subsetSum(int arr[], int n, int W, int[][] mem_t) {
		if (n == 0 && W != 0) {
			return false;
		}
		if (W == 0) {
			return true;
		}
		if (mem_t[n][W] != -1) {
			return mem_t[n][W] == 1;
		}
		if (arr[n - 1] > W) {
			return subsetSum(arr, n - 1, W, mem_t);
		} else {
			if (subsetSum(arr, n - 1, W - arr[n - 1], mem_t) || subsetSum(arr, n - 1, W, mem_t)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 6, 5, 11 };
		int range = 0;
		for (int i = 0; i < arr.length; i++) {
			range = range + arr[i];
		}
		int filterSet[] = new int[range];
		List<Boolean> potentialOutcome = new ArrayList<>();
		for (int i = 0; i < filterSet.length; i++) {
			int mem_t[][] = new int[arr.length + 1][i + 1];
			initializeMemTable(mem_t, arr.length, i);
			potentialOutcome.add(subsetSum(arr, arr.length, i, mem_t));
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i <= potentialOutcome.size() / 2; i++) {
			if (potentialOutcome.get(i)) {
				result.add(rangeVal(range, i));
			}
		}
		System.out.println("Minimum subsetsum diff: " + Collections.min(result));
	}

	public static int rangeVal(int range, int val) {
		return (range - (2 * val));
	}

	private static void initializeMemTable(int[][] mem_t, int n, int w) {
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				mem_t[i][j] = -1;
			}
		}
	}
}
