package com.ds.algo.linklist;

public class DoublyCircularLinkedList {

	DLNode head;
	DLNode tail;
	int size;

	public void add(int data) {
		DLNode node = new DLNode(data, null, null);
		size++;
		if (head == null) {
			head = node;
			node.next=node;
			node.prev=node;
			tail = head;
		} else {
			tail.next = node;
			node.prev = tail;
			node.next = head;
			head.prev=node;
			tail = node;
		}
	}

	public void display() {
		if(size==0){
			System.out.println("Empty");
			return;
		}
		DLNode current=head;
		boolean arrow=false;
		do {
			System.out.print((arrow)?"--> |"+current.data+"|":"|"+current.data+"|");
			current=current.next;
			arrow=true;
		} while (current!=head);
		
	}
}
