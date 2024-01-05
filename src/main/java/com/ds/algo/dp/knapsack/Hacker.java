package com.ds.algo.dp.knapsack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Hacker {
	public static void main(String[] args) {
        // Example usage
        String input = "(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)";
        System.out.println("Output: " + sExpression(input));
    }

    public static String sExpression(String input) {
        Map<String, Node> nodeMap = new HashMap<>();

        // Build the tree
        for (String pair : input.split(" ")) {
            String parent = pair.substring(1, 2);
            String child = pair.substring(3, 4);

            Node parentNode = nodeMap.computeIfAbsent(parent, Node::new);
            Node childNode = nodeMap.computeIfAbsent(child, Node::new);

            parentNode.children.add(childNode);
            childNode.parent = parentNode;
        }

        // Find the root
        Node root = null;
        for (Node node : nodeMap.values()) {
            if (node.parent == null) {
                root = node;
                break;
            }
        }

        if (root == null) {
            return "NO";
        }

        // Serialize the tree
        StringBuilder result = new StringBuilder();
        serialize(root, result);

        return result.toString();
    }

    private static void serialize(Node node, StringBuilder result) {
        if (node == null) {
            return;
        }

        result.append("(").append(node.value);

        for (Node child : node.children) {
            serialize(child, result);
        }

        result.append(")");
    }

    private static class Node {
        String value;
        Node parent;
        Stack<Node> children;

        Node(String value) {
            this.value = value;
            this.children = new Stack<>();
        }
    }
}
