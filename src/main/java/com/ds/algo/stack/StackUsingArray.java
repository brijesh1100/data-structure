package com.ds.algo.stack;

import java.util.Arrays;

public class StackUsingArray {

	int maxSize;
	int top;
	Integer arr[];
	public StackUsingArray(int size){
		this.maxSize=size;
		this.top=0;
		arr= new Integer[maxSize];
	}
	
	public boolean isEmpty(){
		if(top==0){
			return true;
		}
		return false;
	}
	public void push(int data){
		if(top<maxSize){
			arr[top]=data;
			top++;
		}else{
			System.out.println("Stack Overflow !!");
		}
	}
	public int pop(){
		if(isEmpty()){
			System.out.println("Empty Stack");
		}else{
			int tmp=this.peak();
			arr[top-1]=null;
			top--;
			return tmp;
		}
		return 0;
	}
	public int peak(){
		if(!isEmpty()){
			return arr[top-1];
		}
		return 0;
	}

	@Override
	public String toString() {
		return "StackUsingArray [maxSize=" + maxSize + ", top=" + top
				+ ", arr=" + Arrays.toString(arr) + "]";
	}
	
}
