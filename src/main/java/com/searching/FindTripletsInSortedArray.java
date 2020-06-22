package com.searching;

public class FindTripletsInSortedArray {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, 11, 19 };
		int value = 35;
		findTriplets(arr, value);
	}

	static int findTriplets(int[] arr, int value) {
		for (int i = 0; i < arr.length - 1; i++) {
			int newValue = value - arr[i];
			int result = search(arr, newValue, i + 1, arr.length - 1);
			if (-1 != result) {
				System.out.print(" + " + arr[i]);
				return result;
			}
		}
		return -1;
	}

	static int search(int[] arr, int value, int start, int end) {
		if ((arr[start] + arr[end]) == value) {
			System.out.print( arr[start] + " + " + arr[end]);
			return value;
		}
		if (end <= start) {
			return -1;
		}
		if (value < (arr[start] + arr[end])) {
			return search(arr, value, start, end - 1);
		} else {
			return search(arr, value, start + 1, end);
		}
	}
}
