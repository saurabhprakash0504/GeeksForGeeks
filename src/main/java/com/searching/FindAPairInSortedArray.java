package com.searching;

public class FindAPairInSortedArray {
	public static void main(String[] args) {
		int[] arr = { 3, 3, 13, 18 };
		int value = 6;
		System.out.println(search(arr, value, 0, arr.length - 1));
	}

	static int search(int[] arr, int value, int start, int end) {
		if ((arr[start] + arr[end]) == value) {
			System.out.print("found " + arr[start] + " + " + arr[end] + " = ");
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
