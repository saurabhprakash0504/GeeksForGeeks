package com.searching;

public class BinarySearchIterativeApproach {
	public static void main(String[] args) {
		int[] arr = { -10, 10, 15, 44, 60, 80, 100 };
		// System.out.println(binarySearch(arr, 100));
		System.out.println("second " + method2(arr, 100));
	}

	static int binarySearch(int[] arr, int value) {

		int start = 0;
		int end = arr.length;
		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] == value) {
				return mid;
			} else if (value > arr[mid]) {
				start = mid;
			} else if (value < arr[mid]) {
				end = mid;
			}
		}
		return -1;
	}

	static int method2(int[] arr, int x) {
		int beg = 0;
		int end = arr.length - 1;
		while (beg <= end) {

			int mid = beg + (end - beg) / 2;
			// System.out.println("mid >> "+mid);
			if (arr[mid] == x) {
				return mid;
			} else if (x > arr[mid]) {
				beg = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
}
