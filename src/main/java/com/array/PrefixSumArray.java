package com.array;

public class PrefixSumArray {
	public static void main(String[] args) {
		method1(0, 2);
		method1(1, 3);
	}

	static void method1(int start, int end) {
		int[] arr = { 2, 8, 3, 9, 6, 5, 4 };
		int[] temp = new int[arr.length];
		temp[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			temp[i] = arr[i] + temp[i - 1];
		}
		System.out.println("final sum >> " + (temp[end] - temp[start] + arr[start]));
	}
}
