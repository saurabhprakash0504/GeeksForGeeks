package com.recurssion;

public class TowerOfHanoi {
	public static long moves;

	public static void main(String[] args) {
		toh(2, 1, 2, 3);
	}

	public static void toh(int N, int from, int to, int aux) {
		if (N == 1) {
			System.out.println("move disk " + 1 + " from rod " + from + " to rod " + to);
			moves++;
			return;
		}
		toh(N - 1, from, aux, to);
		System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
		moves++;
		toh(N - 1, aux, to, from);
		// System.out.println(moves);
	}

}
