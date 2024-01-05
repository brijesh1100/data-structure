package com.ds.algo.dp.knapsack;

/**
 * Count no of subsets with given difference (DP)
 * Given an array arr[] of size N and a given difference diff, the task is to count the number 
 * of partitions that we can perform such that the difference between the sum of the two subsets
 * is equal to the given difference.
 * 
 * Note: A partition in the array means dividing an array into two parts say S1 and S2 such that 
 * the union of S1 and S2 is equal to the original array and each element is present in only of the subsets.
 * 
 * Input: N = 4, arr[] = [5, 2, 6, 4], diff = 3
 * Output: 1
 * Explanation: We can only have a single partition which is shown below:
 * {5, 2} and {6, 4} such that S1 = 7 and S2 = 10 and thus the difference is 3
 * 
 * Input: N = 5, arr[] = [1, 2, 3, 1, 2], diff = 1
 * Output: 5
 * Explanation: We can have five partitions which is shown below
 * {1, 3, 1} and {2, 2} – S1 = 5, S2 = 4
 * {1, 2, 2} and {1, 3} – S1 = 5, S2 = 4
 * {3, 2} and {1, 1, 2} – S1 = 5, S2 = 4
 * {1, 2, 2} and {1, 3} – S1 = 5, S2 = 4
 * {3, 2} and {1, 1, 2} – S1 = 5, S2 = 4
 * */
public class CountOfSubsetSumWithGivenDiff {

	public static int mem_t[][];

	public static void main(String[] args) {
		int arr[] = { 5, 2, 6, 4 }, diff = 3;
		int n = arr.length;

		int range = 0;
		for (int i = 0; i < arr.length; i++) {
			range = range + arr[i];
		}

//		s1-s2=diff;
//		s1+s2=range;
//	-----------------------
//		2s1 = diff+range;
//		s1 = (diff+range)/2;

		int subsetSum = (diff + range) / 2;
		System.out.println("subsetSum " + subsetSum);
		mem_t = new int[n + 1][subsetSum + 1];
		initilizeMem(n, subsetSum);

		int count = countOfSubsetSum(arr, n, subsetSum);
		System.out.println("Count no of subsets with given difference of " + diff + " is :" + (count));

	}

	private static void initilizeMem(int n, int W) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < W; j++) {
				if (i == 0) {
					mem_t[i][j] = 0;
				}
				if (j == 0) {
					mem_t[i][j] = 1;
				}
			}
		}
	}

	private static int countOfSubsetSum(int[] arr, int n, int w) {

		if (n == 0) {
			return 0;
		}
		if (w == 0) {
			return 1;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				if (arr[i - 1] <= j) {
					mem_t[i][j] = mem_t[i - 1][j - arr[i - 1]] + mem_t[i - 1][j];
				} else {
					mem_t[i][j] = mem_t[i - 1][j];
				}
			}
		}

		return mem_t[n][w];
	}

}
