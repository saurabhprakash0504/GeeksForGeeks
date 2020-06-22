package com.sorting;

public class KthSmallestElementInAnArray {
	public static void main(String[] args) {
		int[] arr = { 10, 4, 5, 8, 11, 6, 26 };
		System.out.println(findKthSmallest(arr, 7));
	}

	static int findKthSmallest(int[] arr, int k) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int pivot = lomutoAlgo(arr, start, end);
			System.out.println("pivot >> " + pivot);
			if (pivot == k - 1) {
				return arr[pivot];
			} else if (pivot < k - 1) {
				start = pivot + 1;
			} else {
				end = pivot - 1;
			}
		}
		return -1;
	}

	static int lomutoAlgo(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = -1;
		for (int j = 0; j < end; j++) {
			if (arr[j] <= pivot) {
				swap(arr, i + 1, j);
				i = i + 1;
			}
		}
		swap(arr, i + 1, end);
		return i + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
