package com.ds.algo.linklist;

public class SinglyCircularLinkedList {

	private SLNode head;
	private SLNode tail;
	private int size;
	
	public void add(int data){
		SLNode node = new SLNode(data, null);
		size++;
		if(head==null){
			head=node;
			tail=head;
			tail.next=head;
		}else {
			tail.next=node;
			tail=node;
			node.next=head;
		}
	}
	public void display(){
		if(size==0){
			System.out.println("empty");
			return;
		}
		SLNode current = head;
		boolean arrow=false;
		do {
			System.out.print((arrow)?"--> |"+current.data+"|": "|"+current.data+"|");
			arrow = true;
			current = current.next;
		} while (current!=head);
	}
	public void size(){
		System.out.println(size);
	}
}
