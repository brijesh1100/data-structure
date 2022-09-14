package com.ds.algo.dp;

/**
 * Minimum number of jumps to reach end Given an array of integers where each
 * element represents the max number of steps that can be made forward from that
 * element. Write a function to return the minimum number of jumps to reach the
 * end of the array (starting from the first element). If an element is 0, then
 * we cannot move through that element. If we can’t reach the end, return -1.
 */
public class MinmumJumps {

	static int baseCondition(int arr[], int length, int pos, int jump) {
		if (length - 1 == pos) {
			return jump;
		} else if (arr[pos] == 0) {
			return -1;
		}
		return -1;
	}

	int minimumJumps(int arr[], int length, int pos, int jump) {

		if (arr[pos] <= length - 1) {

		}

		return jump;

	}

	public static void main(String[] args) {

//		int arr[] = { 2, 9, 6, 4, 1, 3, 3, 3, 2, 1 };
		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };;
//		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int jump = 0;
		baseCondition(arr, arr.length, 0, jump);
		
		for (int i = 0; i < arr.length;) {
			int j = arr[i];
			if (j + i <= arr.length) {
				i = findMaxJumpindex(arr, j, i);
				jump = jump + 1;
			} else {
				jump = jump + 1;
				break;
			}
		}
		System.out.println(jump);

	}

	private static int findMaxJumpindex(int[] arr, int numberOfPossibleJump, int index) {

		int endIndex = numberOfPossibleJump;
		int startIndex = index;
		int checkIndex = startIndex;
		boolean isbaseIndexChange = false;
		for (int i = startIndex; i < endIndex; i++) {
			if (arr[checkIndex] >= arr[i + 1]) {
				continue;
			} else {
				isbaseIndexChange = true;
				checkIndex++;
			}
		}
		if (isbaseIndexChange) {
			checkIndex = checkIndex + index;
		} else {
			checkIndex = numberOfPossibleJump + index;
		}

		System.out.println("largest index: " + checkIndex);

		return checkIndex;
	}

}
