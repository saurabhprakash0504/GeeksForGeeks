package com.searching;

public class FloorSearch {
	public static void main(String[] args) {
		long[] arr = {1 ,2 ,8 ,10, 11, 12, 19};
		long l = 10;
		System.out.println(findFloor(arr, 0, arr.length - 1, l));
	}

	static int findFloor(long arr[], int left, int right, long x) {
		int mid = (left + right) / 2;
		if (arr[0] > x) {
			return -1;
		}
		if (left >= right) {
			return mid;
		}
		if (arr[mid] == x || (arr[mid] < x && arr[mid + 1] > x)) {
			return mid;
		} else if (arr[mid] < x) {
			return findFloor(arr, mid + 1, right, x);
		} else {
			return findFloor(arr, left, mid - 1, x);
		}
	}
}
