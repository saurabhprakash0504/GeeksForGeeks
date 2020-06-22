package com.sorting;

import java.util.Arrays;

public class QuikSortUsingLomutoPartition {
	public static void main(String[] args) {
		int[] arr = { 8, 4, 7, 9, 3, 10, 5 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int[] arr, int l, int h) {
		if (l < h) {
			int pivotElement = lomutoPartition(arr, l, h);
			System.out.println("pivotElement  >> "+pivotElement);
			quickSort(arr, l, pivotElement - 1);
			quickSort(arr, pivotElement + 1, h);
		}
	}

	static int lomutoPartition(int[] arr, int l, int h) {
		int i = -1;
		int pivot = arr[h];
		for (int j = 0; j < h; j++) {
			if (arr[j] < pivot) {
				i = i + 1;
				swap(arr, j, i);
			}
		}
		swap(arr, i + 1, h);
		return i + 1;
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
