package com.sorting;

import java.util.Arrays;

public class HoarePartitionQuickSort {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 8, 4, 2, 7, 1, 10 };
		hoarePart(arr);
	}

	static void hoarePart(int[] arr) {
		int start = -1;
		int end = arr.length;
		int pivot = arr[0];
		while (true) {
			do {
				start++;
			} while (arr[start] < pivot);
			do {
				end--;
			} while (arr[end] > pivot);

			if (start >= end) {
				System.out.println("pivot >> " + end);
				System.out.println(Arrays.toString(arr));
				break;
			}
			swap(arr, start, end);
		}
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

	/*
	static int hoarePart(int[] arr) {
		int pivot = arr[0];
		int start = - 1;
		int end = arr.length-1;

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
	*/
}
