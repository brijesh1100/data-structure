package com.ds.algo.stack;

import com.ds.algo.linklist.SLNode;
import com.ds.algo.linklist.SinglyLinkedList;

public class StackUsingLinkedList {

	SinglyLinkedList list = new SinglyLinkedList();
	
	public void push(int data){
		list.addAtStart(data);
	}
	public void pop(){
		if(!this.isEmpty()){
			SLNode node= list.deleteAtFirst();
			System.out.println("Poped Item"+node.getData());
		}
	}
	@Override
	public String toString() {
		return "StackUsingLinkedList [list=" + list.getHead().getData() + "]";
	}
	public boolean isEmpty(){
		if(this.list.getHead()==null){
			return true;
		}
		return false;
	}
	public void display(){
		list.display();
	}
}
