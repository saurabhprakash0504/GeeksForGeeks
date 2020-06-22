package com.searching;

public class CountOccurance {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 3, 3, 3, 3, 3, 4, 4, 4 };
		System.out.println(binarySearch(arr, 4, 0, arr.length - 1));
	}

	static int count = 0;

	static int binarySearch(int[] arr, int value, int start, int end) {
		if (end < start) {
			return count;
		}
		int mid = (start + end) / 2;
		if (arr[mid] == value) {
			System.out.println("mid " + mid);
			count = count + 1;
		}
		if (arr[mid] >= value) {
			System.out.println("before " + mid);
			binarySearch(arr, value, start, mid - 1);
		}
		if (arr[mid] <= value) {
			System.out.println("after " + mid);
			binarySearch(arr, value, mid + 1, end);
		}
		return count;
	}
}
