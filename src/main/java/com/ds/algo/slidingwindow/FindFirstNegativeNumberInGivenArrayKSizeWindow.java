package com.ds.algo.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * You have been given one arr with +ve and -ve integer You need to find the
 * first -ve value from each subarry input -> arr[] = {12,-1,-7, 13, 5, -20, 8,-9, 1, 1, 22, 4} 
 * Output -> -1,-1,-7,-20,-20,-20,-9,-9, 0,0
 */
public class FindFirstNegativeNumberInGivenArrayKSizeWindow {

	public static void main(String[] args) {
		int[] arr = { 12, -1, -7, 13, 5, -20, 8, -9, 1, 1, 22, 4 };

		List<Integer> list = findFirstNegativeNumber(arr);
		System.out.println(list);
	}

	private static List<Integer> findFirstNegativeNumber(int[] arr) {
		List<Integer> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		int i = 0, j = 0;
		int k = 3;
		while (j < arr.length) {
			if (arr[j] < 0) {
				list.add(arr[j]);
			}
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (list.isEmpty()) {
					list1.add(0);
				} else {
					int val = list.get(0);
					list1.add(val);
					if (arr[i] == list.get(0)) {
						list.remove(0);
					}
				}

				i++;
				j++;
			}

		}

		return list1;
	}
}
