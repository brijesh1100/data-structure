package com.ds.algo.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * 
 * Example 1:

	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
	
 * Example 2:

	Input: nums = [3,2,4], target = 6
	Output: [1,2]
 * 
 * 
 * Constraints:

	2 <= nums.length <= 104
	-109 <= nums[i] <= 109
	-109 <= target <= 109
	Only one valid answer exists.
	
 * */
public class TwoSumProblem {
	

	/**
	 * Approach 1
	 * Brute Force approach
	 * */
	public static int[] twoSumWithApproach1(int[] nums, int target) {
        int arr [] = new int[2];
        if(nums.length >=2 && nums.length <= Math.pow(10, 4)){
            boolean isfound = false;
            int total = 0;
            for(int i=0; i<=nums.length; i++){
                if(nums[i]<=Math.pow(10,9) && nums[i]>=Math.pow(-10, 9)){
                    if(target<= Math.pow(10,9) && target>=Math.pow(-10,9)){
                    	if(isfound) {
                    		break;
                    	}
                    	for (int j = i+1; j < nums.length; j++) {
                    		total = nums[i]+nums[j];
                    		System.out.println("Inner loop");
                            if(target==total){
                            	arr[0] = i;
                            	arr[1] = j;
                            	isfound = true;
                             	break;
                            }
						}
                    }
                }
            }
        }
		return arr;
    }
	/**
	 * Approach 2
	 * Brute Force approach
	 * */
	private static int[] twoSumApproach2(int[] nums, int target) {
		int arr [] = new int[] {};
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			int difference = target - nums[i];
			System.out.println("loop");
			if(map.containsKey(difference)) {
				int value = map.get(difference);
				return new int[]{value,i};
			}
			map.put(nums[i], i);
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = {2,7,11,15,2,55,6,1,2,67,45,7,8,9,1};
		int target = 52;
		int[] result = twoSumWithApproach1(input,target);
		System.out.println("First Approach : "+result[0]+" "+result[1]);
		
		int[] result2 = twoSumApproach2(input, target);
		System.out.println("Second Approach : "+result[0]+" "+result[1]);
	}
}
