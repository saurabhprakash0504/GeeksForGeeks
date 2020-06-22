package com.array;

public class BuyStockAndSellProblem {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 1, 8, 12 };
		// output = 15;
		method1(arr, 0, 0);
		method2(arr);
	}

	static void method1(int[] arr, int start, int sum) {

		if (start == arr.length) {
			System.out.println("sum >> " + sum);
			return;
		}

		int i = start + 1;

		while (i + 1 < arr.length && arr[i + 1] > arr[i]) {
			i++;
		}

		sum = sum + arr[i] - arr[start];

		int j = i + 1;
		while (j + 1 < arr.length && arr[j + 1] < arr[j]) {
			j++;
		}

		method1(arr, j, sum);
	}

	static void method2(int[] arr) {
		int sum = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				sum = sum + (arr[i] - arr[i - 1]);
			}
		}
		System.out.println("sum >> " + sum);
	}
}
