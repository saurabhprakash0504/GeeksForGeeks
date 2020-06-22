package com.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingTwoQueue {
	public static void main(String[] args) {
		ImplementStackUsingTwoQueue i = new ImplementStackUsingTwoQueue();
		i.push(78);
		System.out.println(i.pop());
		System.out.println(i.pop());
		System.out.println(i.pop());
		i.push(93);
		System.out.println(i.pop());
		System.out.println(i.pop());
		i.push(28);
		i.push(60);
		System.out.println(i.pop());
	}

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	int front = 0;
	int back = 0;

	int pop() {
		// Your code here
		int len = q1.size();

		for (int i = 0; i < len-1; i++) {

			q2.add(q1.peek());
			q1.remove();
		}
		int val= -1;
		if(q1.size()>0) {
		    val= q1.peek();
		    q1.remove();
		}
		q1 = q2;
		return val;
	}

	/* The method push to push element into the stack */
	void push(int a) {
		q1.add(a);
	}

}
