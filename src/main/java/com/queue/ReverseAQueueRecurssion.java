package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseAQueueRecurssion {

	public static void main(String[] args) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		q.add(50);
		print(reverseQueue(q));

	}


	private static Queue<Integer> reverseQueue(Queue<Integer> q) {
		if (q.isEmpty()) {
			return q;
		}
		int i = q.poll();

		reverseQueue(q);

		q.add(i);

		return q;
	}


	static void print(Queue<Integer> q) {
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}
