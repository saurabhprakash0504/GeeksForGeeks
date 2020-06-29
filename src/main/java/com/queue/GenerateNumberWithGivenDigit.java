package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumberWithGivenDigit {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(5);
		q.add(6);
		print(3, q);
	}

	static void print(int number, Queue<Integer> q) {
		if (number == 0) {
			return;
		}

		int i = q.poll();
		System.out.println(i);
		q.add(i*10+5);
		q.add(i*10+6);
		print(number - 1, q);
	}
}
