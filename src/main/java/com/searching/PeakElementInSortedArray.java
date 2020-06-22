package com.searching;

public class PeakElementInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(peakElement(arr, arr.length));
	}

	static public int peakElement(int[] a, int n) {
		// add code here.
		if (a[0] >= a[1]) {
			return 1;
		}
		if (a[n - 1] >= a[n - 2]) {
			return 1;
		}
		for (int i = 1; i < n - 2; i++) {
			if (a[i] >= a[i - 1] && a[i] >= a[i + 1]) {
				return 1;
			}
		}
		return -1;
	}

}