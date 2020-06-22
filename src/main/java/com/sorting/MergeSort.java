package com.sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 5, 4, 1, 2, 1, 7, 3 };
		mergeSort(arr, 0, arr.length - 1);
	}

	static void mergeSort(int[] arr, int start, int end) {
		if (end > start) {
			int mid = start + (end - start) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
			System.out.println(Arrays.toString(arr));
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int firstLength = mid - start + 1;
		int secondLength = end - (mid + 1) + 1;
		int[] first = new int[firstLength];
		int[] second = new int[secondLength];
		int i = 0, j = 0;
		int firstStart = start;

		// copying first
		while (i <= firstLength - 1) {
			first[i] = arr[firstStart];
			firstStart++;
			i++;
		}
		int secondStart = mid + 1;
		// copying second
		while (j <= secondLength - 1) {
			second[j] = arr[secondStart];
			secondStart++;
			j++;
		}

		i = 0;
		j = 0;

		while (i != firstLength && j != secondLength) {
			if (first[i] < second[j]) {
				arr[start] = first[i];
				i++;
			} else {
				arr[start] = second[j];
				j++;
			}
			start++;
		}

		// copying rest of the element
		while (i < firstLength) {
			arr[start] = first[i];
			start++;
			i++;
		}

		// copying rest of the element
		while (j < secondLength) {
			arr[start] = second[j];
			j++;
			start++;
		}
	}
}
