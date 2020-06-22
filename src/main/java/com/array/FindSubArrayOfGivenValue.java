package com.array;

public class FindSubArrayOfGivenValue {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 30, -5, 20, 7 };
		method2(arr, 3, 39);
	}

	static void method2(int[] arr, int n, int givenNum) {
		int curr = 0;
		for (int i = 0; i < n; i++) {
			curr = curr + arr[i];
		}
		if (curr == givenNum) {
			System.out.println("yes present");
			return;
		}
		int prev = curr;

		for (int i = 1; i < arr.length - n; i++) {
			curr = prev - arr[i - 1] + arr[n + i - 1];
			prev = curr;
		
			if (curr == givenNum) {
				System.out.println("yes present");
				return;
			}
		}

	}
}
