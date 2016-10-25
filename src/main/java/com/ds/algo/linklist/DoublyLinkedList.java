package com.ds.algo.linklist;

public class DoublyLinkedList {

	DLNode head;
	DLNode tail;
	int size;

	public void add(int data) {
		DLNode node = new DLNode(data, null, null);
		size++;
		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.next=node;
			node.prev=tail;
			tail=node;
		}
	}
	
	public void display() {
		if (size == 0) {
			System.out.println("empty");
			return;
		}
		if (head.getNext() == null) {
			System.out.println(head.getData());
			return;
		}
		DLNode current = head;
		boolean arrow = false;
		do {
			System.out.print((arrow) ? "--> |" + current.data + "|" : "|"
					+ current.data + "|");
			arrow = true;
			current = current.next;
		} while (current != null);
	}
}
