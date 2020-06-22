package com.recurssion;

public class FactorialRecurssion {
	public static void main(String[] args) {
		System.out.println(factorial(4));
		System.out.println("tail recusrrion "+factorialTailRecusrrion(4, 1));
	}

	static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	static int factorialTailRecusrrion(int n, int m) {
		if (n == 0) {
			return m;
		}
		return factorialTailRecusrrion(n-1, m*n);
	}
}
