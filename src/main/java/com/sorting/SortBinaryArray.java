package com.sorting;

import java.util.Arrays;

public class SortBinaryArray {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 1 };
		binSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	static void binSort(int arr[], int n) {
		int ii = 0;
		if (arr[n - 1] == 1) {
			while (ii < arr.length - 1 && arr[ii] == 1) {
				ii++;
			}
			int temp = arr[ii];
			arr[ii] = arr[n - 1];
			arr[n - 1] = temp;
		}
		int j = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[arr.length - 1]) {
				j = j + 1;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		j = j + 1;
		int temp = arr[j];
		arr[j] = arr[arr.length - 1];
		arr[arr.length - 1] = temp;

	}
}
