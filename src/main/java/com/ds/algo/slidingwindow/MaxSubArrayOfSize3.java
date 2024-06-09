package com.ds.algo.slidingwindow;

/**
 * Problem: You have been given and arr = [1,2,3,4,5,6,7,8]
 * find the max 3 array size
 * */
public class MaxSubArrayOfSize3 {

	public static void main(String[] args) {
		
		int[] arr = {2,3,5,9,2,7,1};
		int max = findMaxSubArray(arr);
		System.out.println(max);
	}

	private static int findMaxSubArray(int[] arr) {
		int max = 0;
		int k = 3;
		int start=0, end = start+k;
		int value = getWindow(start, end, arr);
		max = Math.max(max, value);
		for (int i = 0; i < arr.length; i++) {
			if(i+k<arr.length) {
				value  = value - arr[i] + arr[i+k];
				max = Math.max(max, value);
			}
		}
		return max;
	}

	private static int getWindow(int start, int end, int[] arr) {
		return arr[0]+arr[1]+arr[2];
	}
	
}
