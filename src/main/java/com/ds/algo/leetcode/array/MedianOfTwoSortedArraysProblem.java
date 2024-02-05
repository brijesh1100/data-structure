package com.ds.algo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MedianOfTwoSortedArraysProblem {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		ArrayList<Integer> arr1 = (ArrayList<Integer>) Arrays.stream(nums1).boxed().collect(Collectors.toList());
		ArrayList<Integer> arr2 = (ArrayList<Integer>) Arrays.stream(nums2).boxed().collect(Collectors.toList());
		List<Integer> all = new ArrayList<>();
		all.addAll(arr1);
		all.addAll(arr2);
		Collections.sort(all);
		int size  =  all.size();
		if(size % 2 == 0) {
			int indx1=((size)/2)-1;
			int indx2 = indx1+1;
			System.out.println(indx1);
			System.out.println(indx2);
			Double val1= Double.valueOf(all.get(indx1));
			Double val2= Double.valueOf(all.get(indx2));
			System.out.println(val1+" "+val2);
			return (val1+val2)/2;
		}else {
			int indx1=((size-1)/2)-1;
			int indx2 = indx1+1;
			return all.get(indx2);
		}

	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,2};
		int[] arr2 = {3,4};
		System.out.println(findMedianSortedArrays(arr1,arr2));
	}
	
}
