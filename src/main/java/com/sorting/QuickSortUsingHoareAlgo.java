package com.sorting;

import java.util.Arrays;

public class QuickSortUsingHoareAlgo {
	public static void main(String[] args) {
		int[] arr = { 10, 80, 30, 90, 40, 50, 70 };
		//int[] arr= {10, 7, 8, 9, 1, 5};
		hoareParting(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void hoareParting(int[] arr, int l, int r) {
		if (l < r) {
			int mid = hoarePart(arr, l, r);
			hoareParting(arr, l, mid);
			hoareParting(arr, mid + 1, r);
		}
	}

	static int hoarePart(int[] arr, int l, int r) {
		int pivot = arr[l];
		int start = l - 1;
		int end = r + 1;

		while (true) {
			do {
				start++;
			} while (arr[start] < pivot);
			do {
				end--;
			} while (arr[end] > pivot);

			if (start >= end) {
				System.out.println("pivot >> " + start);
				System.out.println("start >> " + start + " end >> " + end);
				System.out.println(Arrays.toString(arr));
				return end;
			}
			swap(arr, start, end);

		}
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
}
