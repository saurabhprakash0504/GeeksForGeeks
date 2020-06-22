package com.sorting;

import java.util.Arrays;

public class MergeSortVariation {
	public static void main(String[] args) {
		int[] arr = { 90, 10, 15, 20, 40, 8, 11, 15, 22, 25 };
		merge(arr, 1, 9, 4);
		System.out.println(Arrays.toString(arr));
	}

	static void merge(int[] arr, int l, int h, int mid) {
		int[] first = new int[mid - l + 1];
		int[] second = new int[h - mid];
		int firstLength = first.length;
		int secondLength = second.length;

		int i = 0, j = 0;
		int firstl = l;

		// copying first
		while (i <= firstLength - 1) {
			first[i] = arr[firstl];
			firstl++;
			i++;
		}
		int secondl = mid + 1;
		// copying second
		while (j <= secondLength - 1) {
			second[j] = arr[secondl];
			secondl++;
			j++;
		}

		i = 0;
		j = 0;

		while (i != firstLength && j != secondLength) {
			if (first[i] < second[j]) {
				arr[l] = first[i];
				i++;
			} else {
				arr[l] = second[j];
				j++;
			}
			l++;
		}

		// copying rest of the element
		while (i < firstLength) {
			arr[l] = first[i];
			l++;
			i++;
		}

		// copying rest of the element
		while (j < secondLength) {
			arr[l] = second[j];
			j++;
			l++;
		}

	}
}
