package com.ds.algo.linklist;

/**
 * Single LinkList Node data structure
 * */
public class SLNode implements Comparable<Integer> {
	Integer data;
	SLNode next;

	SLNode(int data, SLNode node) {
		this.data = data;
		next = node;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public SLNode getNext() {
		return next;
	}

	public void setNext(SLNode next) {
		this.next = next;
	}

	public int compareTo(Integer val) {
		if (val == this.data) {
			return 0;
		} else {
			return 1;
		}
	}
}
