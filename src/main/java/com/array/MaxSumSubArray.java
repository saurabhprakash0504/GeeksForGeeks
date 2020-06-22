package com.array;

public class MaxSumSubArray {
	public static void main(String[] args) {
		method1();
		method2();
	}

	static void method1() {
		int[] arr = { -5, 11, -2, 3, -1, 2, -2 };
		int sum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int temp = 0;
			for (int j = i; j < arr.length; j++) {
				temp = temp + arr[j];
				if (temp > sum) {
					sum = temp;
				}
			}

		}
		System.out.println("sum >> " + sum);
	}

	static void method2() {
		int[] arr = { -5, 11, -2, 3, -1, 2, -2 };
		int[] temp = new int[arr.length];
		temp[0] = arr[0];
		int big = temp[0];
		for (int i = 1; i < arr.length; i++) {
			int sum = temp[i - 1] + arr[i];
			if (sum > arr[i]) {
				temp[i] = sum;
			} else {
				temp[i] = arr[i];
			}
			if (temp[i] > big) {
				big = temp[i];
			}

		}
	
		System.out.println("big >> " + big);
	}
}
