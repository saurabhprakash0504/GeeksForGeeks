package com.searching;

public class BinarySearchRecurssion {
	public static void main(String[] args) {
		int[] arr = { -10, 10, 15, 44, 60, 80, 100 };
		System.out.println(binarySearch(arr, 80, 0, arr.length - 1));
	}

	static int binarySearch(int[] arr, int value, int start, int end) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (arr[mid] == value) {
			return mid;
		} else if (arr[mid] > value) {
			 return binarySearch(arr, value, start, mid-1);
		} else {
			return binarySearch(arr, value, mid+1, end);
		}
	}
}
