package com.searching;

public class PeakElementInUnsortedArray {
	public static void main(String[] args) {
		int[] arr = { 70000, 1600, 180, 80, 70 };
		findPeak(arr, 0, arr.length - 1);
	}

	static void findPeak(int[] arr, int start, int end) {
		int mid = start + (end - start) / 2;
		if (mid == 0) {
			if (arr[mid] >= arr[mid + 1]) {
				System.out.println(arr[mid]);
				return;
			}
		} else if (mid == arr.length - 1) {
			if (arr[mid - 1] <= arr[mid]) {
				System.out.println(arr[mid]);
				return;
			}
		} else if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
			System.out.println(arr[mid]);
			return;
		} else if (arr[mid + 1] > arr[mid]) {
			findPeak(arr, mid, end);
		} else {
			findPeak(arr, start, mid);
		}
		// return -1;
	}
}
