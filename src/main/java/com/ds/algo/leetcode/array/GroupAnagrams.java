package com.ds.algo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * */
public class GroupAnagrams {
	
//	First will create anagram with brute force approach
	/**
	 * An anagram is a word or phrase that is created by rearranging the letters of another word or phrase. 
	 * For example, the letters that make up “A decimal point” can be turned into the anagram “I'm a dot in place”.
	 * But this is tricky in our case we are getting char array you can also say one continues string.
	 * 
	 * how many combination possible = factorial of length
	 * */
	public static List<String> anagram(char[] arr){
		List<String> anagrams = new ArrayList<>();
		int length = arr.length;
		generateCombination(arr, 0, arr.length-1, anagrams);
		return anagrams;
	}

	private static List<String> generateCombination(char[] arr, int start, int end, List<String> anagrams) {
		
		
		
		return anagrams;
	}

	private static String getString(char[] arr) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			builder.append(arr[i]);
		}
		return builder.toString();
	}

}
