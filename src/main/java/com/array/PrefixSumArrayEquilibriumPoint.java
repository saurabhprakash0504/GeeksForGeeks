package com.array;

public class PrefixSumArrayEquilibriumPoint {
	public static void main(String[] args) {
		int[] arr = { -2, 2, 4};
		method1(arr);
		method2(arr);
		method3(arr);
	}

	static void method1(int[] arr) {
		int flag = 0;
		for (int i = 0; i < arr.length; i++) {
			int prev = 0;
			int forward = 0;
			for (int j = 0; j < i; j++) {
				prev = prev + arr[j];
			}
			for (int k = i + 1; k < arr.length; k++) {
				forward = forward + arr[k];
			}

			if (prev == forward) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println("not found >> ");
		} else {
			System.out.println("found");
		}
	}

	static void method2(int[] arr) {
		int[] temp = new int[arr.length];
		temp[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			temp[i] = arr[i] + temp[i - 1];
		}
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				if (0 == (temp[arr.length - 1] - temp[i])) {
					System.out.println("found >>" + i);
					return;
				}
			} else {
				if (temp[i - 1] == (temp[arr.length - 1] - temp[i])) {
					System.out.println("found >>" + i);
					return;
				}
			}
		}

		System.out.println("not found");

	}

	static void method3(int[] arr) {
		int totalSum = 0;
		for (int i = 0; i < arr.length; i++) {
			totalSum = totalSum + arr[i];
		}
		int left = 0;
		for (int i = 0; i < arr.length; i++) {
			if (left == (totalSum - arr[i])) {
				System.out.println("found>>" + i);
				return;
			}
		}
		System.out.println("not found");
	}
}
