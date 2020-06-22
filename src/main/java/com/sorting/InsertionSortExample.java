package com.sorting;

import java.util.Arrays;

public class InsertionSortExample {
	public static void main(String[] args) {
		int[] arr= {10 ,9 ,8 ,7 ,6 ,5 ,4 ,3, 2, 1};
		for(int i=1;i<arr.length;i++) {
			insert(arr, i);
		}
		System.out.println(Arrays.toString(arr));
	}

	static void insert(int arr[], int i) {
		// Your code here
		// Arrays.sort(arr);
		// for (int i=1;i<arr.length;i++){
		if (arr[i - 1] > arr[i]) {
			int temp = arr[i];
			while (i > 0 && arr[i - 1] >= temp) {
				arr[i] = arr[i - 1];
				i = i - 1;
			}
			// System.out.println("hello ");
			arr[i] = temp;
		}
		// }
	}
}
