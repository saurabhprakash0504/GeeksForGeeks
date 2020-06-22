package com.stack;

import java.util.Stack;

public class DeleteMidElement {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(deleteMid(s, s.size(), 0));
	}

	public static Stack<Integer> deleteMid(Stack<Integer> s, int sizeOfStack, int current) {
		// if current is equal to half of size of stack
		if (current == sizeOfStack / 2) {
			s.pop();
			return s;
		}

		int x = s.pop();
		current ++;

		// recursively call deleteMid
		deleteMid(s, sizeOfStack, current);
		s.push(x);

		return s;
	}

}
