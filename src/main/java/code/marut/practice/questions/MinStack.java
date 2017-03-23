package code.marut.practice.questions;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> mainStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(Integer num){
		mainStack.push(num);
		if(minStack.isEmpty() || minStack.peek()>num){
			minStack.push(num);
		}
	}
	
	public Integer pop(){
		Integer tmp=mainStack.pop();
		if(tmp.equals(minStack.peek())) minStack.pop();
		return tmp;
	}
	
	public Integer top(){
		return mainStack.peek();
	}

	public Integer min(){
		return minStack.peek();
	}
}
