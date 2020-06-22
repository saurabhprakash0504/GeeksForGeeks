package com.recurssion;

public class PrintingNumberInReverse {
	public static void main(String[] args) {
		printReverse(8);
	}

	static void printReverse(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		printReverse(n - 1);
	}
}
