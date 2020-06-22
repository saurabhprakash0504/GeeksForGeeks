package com.stack;

import java.util.Stack;

public class PreviousGreaterElement {
	public static void main(String[] args) {
		int[] arr = { 15,10 ,18,12,4, 6,2,8};
		//           {-1,15,-1,18,12,12,6,12}
		previousGreaterElement(arr);
	}

	static void previousGreaterElement(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(arr[0]);
		System.out.print("-1");
		for(int i=1;i<arr.length;i++) {
			while(!stack.isEmpty() && stack.peek()<arr[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				System.out.print(" -1");
			}else {
				System.out.print(" "+stack.peek());
			}
			stack.push(arr[i]);
		}
	}
}
