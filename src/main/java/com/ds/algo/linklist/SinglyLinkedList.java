package com.ds.algo.linklist;

public class SinglyLinkedList {

	private Node head;
	private Node tail;
	private int size;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public void addAtStart(int data) {
		Node node = new Node(data, null);
		size++;
		if (head == null) {
			head = node;
			tail = head;
		} else {
			node.setNext(head);
			head = node;
		}
	}

	public void add(int data) {
		Node node = new Node(data, null);
		size++;
		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.setNext(node);
			tail = node;
		}
	}

	public void addInBetween(int data, int pos) {
		Node node = new Node(data, null);
		Node ptr = head;
		pos = pos - 1;
		for (int i = 0; i < size; i++) {
			if(i==pos){
				Node tmp=ptr.getNext();
				ptr.setNext(node);
				node.setNext(tmp);
				break;
			}
		}
	}
}
