package com.ds.algo.dp.matrics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OptTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			int N = Integer.parseInt(br.readLine().trim());
			String[] arr_A = br.readLine().split(" ");
			int[] A = new int[N];
			for (int i_A = 0; i_A < arr_A.length; i_A++) {
				A[i_A] = Integer.parseInt(arr_A[i_A]);
			}

			int out_ = find_difference_index(A);
			wr.println(out_);
		}

		wr.close();
		br.close();
	}

	static int find_difference_index(int[] A) {
		int totalDifference = 0;
		// Loop through each element
		for (int i = 0; i < A.length - 1; i++) {
			// Loop through elements after the current element
			for (int j = i + 1; j < A.length; j++) {
				// Check if current element is less than the next element
				if (A[i] < A[j]) {
					// Count the difference between indexes (inclusive)
					totalDifference += j - i;
				}
			}
		}
		return totalDifference;

	}
}
