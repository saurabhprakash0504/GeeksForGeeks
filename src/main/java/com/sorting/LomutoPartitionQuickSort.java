package com.sorting;

import java.util.Arrays;

public class LomutoPartitionQuickSort {
	public static void main(String[] args) {
		int[] arr = { 10, 80, 30, 90, 40, 50, 70 };
		lomutoPartition(arr);
	}

	static void lomutoPartition(int[] arr) {
		int i = -1;
		int pivot = arr[arr.length - 1];
		for (int j = 0; j < (arr.length - 1); j++) {
			if (arr[j] < pivot) {
				i = i + 1;
				swap(arr, j, i);
			}
		}
		swap(arr, i + 1, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	// If pivot element is not in between then swap the given position of the pivot
	// with the last element
}
