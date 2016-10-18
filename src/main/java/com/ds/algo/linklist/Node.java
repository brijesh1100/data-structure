package com.ds.algo.linklist;

public class Node implements Comparable<Integer>{
	Integer data;
	Node next;
	
	Node(int data, Node node){
		this.data=data;
		next=node;
	}
	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public int compareTo(Integer val) {
		if(val==this.data){
			return 0;
		}else{
			return 1;
		}
	}
}
