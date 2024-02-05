package com.ds.algo.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class ContainerWithMostWaterProblem {

	public static int maxArea(int[] height) {
		Map<Integer,Integer> map = new HashMap<>();
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i+1; j < height.length; j++) {
				int minHeight  = Math.min(height[i], height[j]);
				System.out.println(minHeight);
				int currMax= minHeight * j;
                if(maxArea<=currMax){
                	maxArea = currMax;
                }
			}
		}
		
		return maxArea;

	}

	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		int result = maxArea(height);
		System.out.println(result);
	}
}
