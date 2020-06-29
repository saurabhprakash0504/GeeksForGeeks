package com.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseAQueueIterative {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		print(reverseQueue(q));

	}

	static Queue<Integer> reverseQueue(Queue<Integer> q) {
		Stack<Integer> s = new Stack<Integer>();
		while(!q.isEmpty()) {
			s.push(q.poll());
		}

		while(!s.isEmpty()) {
			q.add(s.pop());
		}

		return q;
	}

	static void print(Queue<Integer> q) {
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
}
