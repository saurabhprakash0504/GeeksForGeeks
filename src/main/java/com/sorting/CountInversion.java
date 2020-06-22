package com.sorting;

import java.util.Arrays;

public class CountInversion {
	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 11, 3, 6, 9, 13 };
		// method1(arr);
		method2(arr);
	}

	static void method1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					System.out.println(arr[i] + " " + arr[j]);
				}
			}
		}
	}

	static void method2(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		System.out.println("count >> " + count);
	}

	static int count = 0;

	static void mergeSort(int[] arr, int start, int end) {
		if (end > start) {
			int mid = start + (end - start) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
			// System.out.println(Arrays.toString(arr));
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
				count = count + (firstLength - j);
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
