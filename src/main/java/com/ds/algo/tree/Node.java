package com.ds.algo.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	int data;
	Node left;
	Node right;

	public static void main(String[] args) {
		System.out.println("sajakskj");
		List<String> list =  new ArrayList<>();
		list.add("APE");
		list.add("TAP");
		list.add("OAT");
		list.add("OAR");
		list.add("MAN");
		list.add("OPT");
		list.add("APT");
		list.add("ATE");
		list.add("MAT");
		Map<String, List<String>> graph = createWordGraph(list);
		System.out.println(graph);
	}

	private static Map<String, List<String>> createWordGraph(List<String> vocabulary) {
		Map<String, List<String>> graph = new HashMap<>();

		for (String word : vocabulary) {
			graph.put(word, new ArrayList<>()); // Initialize an empty neighbor list
		}
		for (int i = 0; i < vocabulary.size(); i++) {
			for (int j = i + 1; j < vocabulary.size(); j++) {
				if (isOneCharDifferent(vocabulary.get(i), vocabulary.get(j))) {
					graph.get(vocabulary.get(i)).add(vocabulary.get(j));
					graph.get(vocabulary.get(j)).add(vocabulary.get(i));
				}
			}
		}
		return graph;
	}

	private static boolean isOneCharDifferent(String word1, String word2) {
		int diffCount = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				diffCount++;
				if (diffCount > 1) {
					return false;
				}
			}
		}
		return diffCount == 1;
	}

}
