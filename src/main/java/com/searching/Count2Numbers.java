package com.searching;

public class Count2Numbers {
	public static void main(String[] args) {
		int[] arr = {1, 2, 2 ,1};
		twoRepeated(arr, arr.length);
	}

	static void twoRepeated(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			if (arr[Math.abs(arr[i])] > 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else {
				System.out.print(Math.abs(arr[i])+" ");
			}
		}

	}
}
