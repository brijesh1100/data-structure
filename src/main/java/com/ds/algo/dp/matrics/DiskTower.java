package com.ds.algo.dp.matrics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class DiskTower {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine().trim());
		String[] arr_arr = br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
			arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
		}

		ArrayList<Integer>[] out_ = Solve(arr);
		for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {

			for (int j_out_ = 0; j_out_ < out_[i_out_].size(); j_out_++) {
				System.out.print(out_[i_out_].get(j_out_) + " ");
			}
			System.out.println("");
		}

		wr.close();
		br.close();
	}

	static ArrayList<Integer>[] Solve(int[] arr) {
		int n = arr.length;

		// Initialize a priority queue to store disks
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		// Initialize the result array
		ArrayList<Integer>[] result = new ArrayList[n];

		// Process each day
		
		for (int i = 0; i < n; i++) {
			int disk = arr[i];
			pq.add(disk);

			// Initialize the result list for the current day
			result[i] = new ArrayList<>();
			
			if(i==n-1) {
				while(!pq.isEmpty()) {
					int largestDisk = pq.poll();
					result[i].add(largestDisk);
				}
			}
			// Try placing disks on top of the tower
			while (!pq.isEmpty()) {
				// Get the largest disk that can be placed
				int largestDisk = pq.poll();
				if (largestDisk >= arr[i+1]) { // Check if the disk can be placed on this day
					result[i].add(largestDisk);
					
				} else {
					// If the disk cannot be placed, put it back into the priority queue
					pq.add(largestDisk);
					
					break; // Move to the next day
				}
			}
			
		}

		return result;

	}
}
