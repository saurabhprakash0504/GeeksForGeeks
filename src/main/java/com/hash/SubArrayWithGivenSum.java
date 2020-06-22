package com.hash;

import java.util.HashSet;

public class SubArrayWithGivenSum {
	public static void main(String[] args) {
		int[] arr = { 15, 2, 8, 10, -5, -8, 6 };
		int sum = 3;
		method1(arr, sum);
		method2(arr, sum);
	}

	static void method1(int[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			int currSum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				currSum = currSum + arr[j];
				if (currSum == sum) {
					System.out.println("found from " + i + " till " + j);
					return;
				}
			}

		}
		System.out.println("not found");
	}

	static void method2(int[] arr, int sum) {
		HashSet<Integer> h = new HashSet<Integer>();
		int prev = 0;
		for (int i = 0; i < arr.length; i++) {
			prev = prev + arr[i];
			int diff = prev - sum;
			if (h.contains(diff)) {
				System.out.println("found");
				return;
			}

			h.add(prev);
		}
		System.out.println("not found");
	}
}
