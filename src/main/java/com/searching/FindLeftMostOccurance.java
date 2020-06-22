package com.searching;

public class FindLeftMostOccurance {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 3, 3, 3, 3 }; // output -> 1
		System.out.println(binarySearch(arr, 3, 0, arr.length - 1, -1));
	}

	static int binarySearch(int[] arr, int value, int start, int end, int loc) {
		if (end < start) {
			return loc;
		}
		int mid = (start + end) / 2;
		if (arr[mid] == value) {
			loc = mid;
			// return mid;
		}
		if (arr[mid] >= value) {
			return binarySearch(arr, value, start, mid - 1, loc);
		}
		if (arr[mid] <= value) {
			return binarySearch(arr, value, mid + 1, end, loc);
		}
		return loc;
	}
}
