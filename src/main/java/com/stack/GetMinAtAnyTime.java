package com.stack;

import java.util.Stack;

public class GetMinAtAnyTime {
	static Stack<Integer> original = new Stack<Integer>();
	static Stack<Integer> minVal = new Stack<Integer>();

	public static void main(String[] args) {

		original.push(5);
		pushOperatoion(5);
		original.push(10);
		pushOperatoion(10);
		original.push(20);
		pushOperatoion(20);
		original.push(2);
		pushOperatoion(2);
		original.push(6);
		pushOperatoion(6);
		original.push(4);
		pushOperatoion(4);
		System.out.println(minVal.peek());
		popOperation();
		popOperation();
		System.out.println(minVal.peek());
		popOperation();
		System.out.println(minVal.peek());

	}

	static public void pushOperatoion(int val) {
		if (minVal.isEmpty() || minVal.peek() >= val) {
			minVal.push(val);
		}
	}

	static public void popOperation() {
		if (minVal.peek() == original.peek()) {
			minVal.pop();
		}
		original.pop();
	}

}
