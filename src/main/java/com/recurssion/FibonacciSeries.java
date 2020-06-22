package com.recurssion;

public class FibonacciSeries {
	public static void main(String[] args) {
		System.out.println(FibonacciSeries.fibonacci(4));
	}

	static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
