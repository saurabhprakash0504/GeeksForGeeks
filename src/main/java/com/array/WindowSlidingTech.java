package com.array;

public class WindowSlidingTech {
	public static void main(String[] args) {
		int[] arr = {5, -10, 6, 90, 3};
		method1(arr, 2);
		method2(arr, 2);
	}

	static void method1(int[] arr, int n) {
		int sum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - n; i++) {
			int curr = 0;
			for (int j = i; j < (i + n); j++) {
				curr = curr + arr[j];
			}
			if (curr > sum) {
				sum = curr;
			}
		}
		System.out.println("method1 >> " + sum);
	}

	static void method2(int[] arr, int n) {
		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			maxSum = maxSum + arr[i];
		}
		int curr = 0;
		int prev = maxSum;
		
		for (int i = 1; i < arr.length - n; i++) {
			curr = prev - arr[i - 1] + arr[n+i-1];
			prev = curr;
			
			if (curr > maxSum) {
				maxSum = curr;
			}
		}
		System.out.println("method2 "+maxSum);
	}

}
