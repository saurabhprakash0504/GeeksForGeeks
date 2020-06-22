package com.sorting;

import java.util.Arrays;

class GFG {
	public static void main(String[] args) {
		int[] arr = { 7, 10, 4, 3, 20, 15 };
		int number = 6;
		int start = 0;
		int end = arr.length - 1;
		while (end >= start) {
			int pivot = quickSort(arr, start, end, number);
			if (number - 1 == (pivot)) {
				System.out.println("pivot " + arr[pivot]);
				break;
			} else if ((number - 1) > (pivot)) {
				start = pivot + 1;
			} else {
				end = pivot - 1;
			}
		}
	}

	static int quickSort(int[] arr, int start, int end, int number) {
		int pivot = arr[end];
		int j = start - 1;
		for (int i = start; i <= end; i++) {
			if (arr[i] < pivot) {
				j = j + 1;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		j = j + 1;
		int temp = arr[j];
		arr[j] = pivot;
		arr[end] = temp;

		System.out.println(Arrays.toString(arr));
		System.out.println("end >> " + end);
		return j;
	}
}