package com.ds.algo.dp.knapsack;

import java.util.Iterator;

/**
 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the 
 * sum of elements in both subsets is the same.
 * arr[] = {1, 5, 11, 5}
 * Output: true 
 * The array can be partitioned as {1, 5, 5} and {11}
 * arr[] = {1, 5, 3}
 * Output: false 
 * The array cannot be partitioned into equal sum sets.
 * Will do this first with recursion brute force  
 * */
public class EqualSumPartitionWithRecusrion {

	public static void main(String[] args) {
		int arr[] = { 1, 5, 11, 5 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		if (sum % 2 == 0) {
			boolean isTrue = subsetSumPartition(arr, arr.length, sum / 2);
			System.out.println(isTrue);
		} else {
			System.out.println(false);
		}
	}

	private static boolean subsetSumPartition(int[] arr, int n, int W) {
		if (n == 0) {
			return false;
		}
		if (W == 0) {
			return true;
		}
		if (arr[n - 1] <= W) {
			return subsetSumPartition(arr, n - 1, W - arr[n - 1]) || subsetSumPartition(arr, n - 1, W);
		} else {
			return subsetSumPartition(arr, n - 1, W);
		}
	}

}
