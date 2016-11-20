package com.ds.algo.tree;

public class BinaryTree {
	Node root;

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (node.left == null) {
				node.left = insert(node.left, data);
			} else if (node.right == null) {
				node.right = insert(node.right, data);
			}
		}
		return node;
	}

	public int countNode() {
		return countNode(root);
	}

	private int countNode(Node root) {
		if (root == null) {
			return 0;
		} else {
			int noOfNode = 1;
			noOfNode += countNode(root.left);
			noOfNode += countNode(root.right);
			return noOfNode;
		}
	}

	public int getLevelOfTree() {
		int level = 0;
		int lLevel = getLeftLevel(root, level);
		int rLevel = getRightLevel(root, level);
		if (lLevel >= rLevel) {
			return lLevel;
		} else {
			return rLevel;
		}
	}

	private int getRightLevel(Node node, int level) {
		if (node == null) {
			return 0;
		} else {
			if (node.right != null) {
				level = getRightLevel(node.right, level + 1);
			}else if(node.left !=null){
				level = getRightLevel(node.left, level + 1);
			}
		}
		return level;
	}
	
	public int getHeight(){
		return getLevelOfTree()+1;
	}
	private int getLeftLevel(Node node, int level) {
		if (node == null) {
			return 0;
		} else {
			if (node.left != null) {
				level = getLeftLevel(node.left, level + 1);
			}else if(node.right !=null){
				level = getLeftLevel(node.left, level + 1);
			}
		}
		return level;
	}

	public boolean isEmpty() {
		if (root == null)
			return true;
		return false;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(30);
		tree.root.left = new Node(24);
		tree.root.right = new Node(36);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(25);
		tree.root.right.left=new Node(35);
		tree.root.right.right=new Node(39);
		tree.root.right.right.left=new Node(38);
		tree.root.right.right.left.right=new Node(45);
		System.out.println("Level Of Tree: "+tree.getLevelOfTree());
		System.out.println("Height Of Tree: "+tree.getHeight());
	}
}
