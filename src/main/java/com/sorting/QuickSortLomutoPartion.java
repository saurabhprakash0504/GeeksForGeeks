package com.sorting;

import java.util.Arrays;

public class QuickSortLomutoPartion {
	public static void main(String[] args) {
		int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println("final array >> " + Arrays.toString(arr));
	}

	static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			int pi = new QuickSortLomutoPartion().partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);

		}
	}

	int partition(int arr[], int low, int high) {
		int i = low - 1;
		int pivot = arr[high];

		for (int j = low; j <= high - 1; j++) {
			if (arr[j] <= pivot) {
				i = i + 1;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

}
