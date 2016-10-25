package com.ds.algo.linklist;

public class DLNode implements Comparable<Integer>{

	Integer data;
	DLNode next;
	DLNode prev;

	public DLNode(int data, DLNode next, DLNode prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public DLNode getNext() {
		return next;
	}

	public void setNext(DLNode next) {
		this.next = next;
	}

	public DLNode getPrev() {
		return prev;
	}

	public void setPrev(DLNode prev) {
		this.prev = prev;
	}

	@Override
	public int compareTo(Integer val) {
		if (val == this.data) {
			return 0;
		} else {
			return 1;
		}
	}

}
