package com.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args) {
		int[] arr = { 5, 15, 10, 8, 6, 12, 9, 18 };
		// {15,18,12,12,12,18,18,-1};
		nextGreaterElement(arr);
	}

	static void nextGreaterElement(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		stack.push(arr[arr.length - 1]);
		al.add(-1);

		for (int i = arr.length - 2; i >= 0; i--) {
			if (stack.peek() > arr[i]) {
				al.add(stack.peek());
				stack.push(arr[i]);
			} else {
				while (!stack.isEmpty() && stack.peek() < arr[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					al.add(-1);
				} else {
					al.add(stack.peek());
				}
				stack.push(arr[i]);
			}
		}
		Collections.reverse(al);
		System.out.println(al);
	}
}
