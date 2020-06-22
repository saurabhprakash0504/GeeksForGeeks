package com.array;

public class MaxEvenOdd {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		System.out.println(maxEvenOdd(arr, arr.length));
	}

	public static int maxEvenOdd(int arr[], int n) {
		// your code here
		int max = 1;
		int curr = 1;
		for (int i = 0; i < n - 2; i++) {

			while (i < n - 2) {
				//System.out.println("arr[i] >> "+arr[i]+" "+"arr[i + 1] >> "+arr[i + 1]);
				if (arr[i] % 2 != arr[i + 1] % 2) {
					curr++;
					i++;
				} else {
					if (curr > max) {
						max = curr;

					}
					curr = 1;
					break;
				}
			}
		}
		if (arr[arr.length-1] % 2 != arr[arr.length-2] % 2) {
			curr++;
		}
		if (curr > max) {
			max = curr;
		}
		return max;
	}
}
