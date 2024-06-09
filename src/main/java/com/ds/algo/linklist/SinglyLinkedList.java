package com.ds.algo.linklist;

/**
 * Head Tail | | SLNode(data)-> SLNode(data)-> SLNode(data)->SLNode(data) Add
 * Display
 * */
public class SinglyLinkedList {

	private SLNode head;
	private SLNode tail;
	private int size;

	public SLNode getHead() {
		return head;
	}

	public void setHead(SLNode head) {
		this.head = head;
	}

	public SLNode getTail() {
		return tail;
	}

	public void setTail(SLNode tail) {
		this.tail = tail;
	}

	/**
	 * Scenario 1: Empty Linked List Scenario 2: Non Empty Linked List
	 * */
	public void addAtStart(int data) {
		SLNode node = new SLNode(data, null);
		size++;
		// Scenario 1: Empty Linked List
		if (head == null) {
			head = node;
			tail = head;
		} else {
			// Scenario 2: Non Empty Linked List
			node.setNext(head);
			head = node;
		}
	}

	public void add(int data) {
		SLNode node = new SLNode(data, null);
		size++;
		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.next=node;
			tail = node;
		}
	}

	public void addInBetween(int data, int pos) {
		SLNode node = new SLNode(data, null);
		SLNode ptr = head;
		pos = pos - 1;
		for (int i = 0; i < size; i++) {
			if (i == pos) {
				SLNode tmp = ptr.getNext();
				ptr.setNext(node);
				node.setNext(tmp);
				break;
			}
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
		SLNode current = head;
		boolean arrow = false;
		do {
			System.out.print((arrow) ? "--> |" + current.data + "|" : "|"
					+ current.data + "|");
			arrow = true;
			current = current.next;
		} while (current != null);
	}

	public SLNode deleteAtFirst() {
		if (head == null) {
			return null;
		} else {
			SLNode current=head;
			head=head.next;
			return current;
		}
	}

	public SLNode find(int data) {
		if (head == null) {
			return null;
		}
		if (head.data == data) {
			return head;
		}

		SLNode current = head;
		do {
			current = current.next;
			if (current.data == data) {
				return current;
			}
		} while (current != null);
		return null;
	}
}
