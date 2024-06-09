package com.ds.algo.dp.matrics;

import java.io.*;
import java.util.*;


public class CheckTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] arr_A = br.readLine().split(" ");
         int[] A = new int[N];
         for(int i_A = 0; i_A < arr_A.length; i_A++)
         {
         	A[i_A] = Integer.parseInt(arr_A[i_A]);
         }

         int out_ = solve(N, A);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int solve(int N, int[] A){
    	
int maxValue = 100000;
        
        // Step 2: Create an array to count occurrences of each number
        int[] count = new int[maxValue + 1];
        for (int num : A) {
            count[num]++;
        }
        
        // Step 3: Create an array to count how many multiples each number has
        int[] multipleCount = new int[maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            for (int j = i; j <= maxValue; j += i) {
                multipleCount[i] += count[j];
            }
        }

        // Step 4: Find the largest P such that multipleCount[P] == P
        int specialNumber = -1;
        for (int i = 1; i <= maxValue; i++) {
            if (multipleCount[i] == i) {
                specialNumber = i;
            }
        }

        return specialNumber;
    }
}
