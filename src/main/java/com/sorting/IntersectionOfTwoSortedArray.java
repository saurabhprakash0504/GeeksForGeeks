package com.sorting;

public class IntersectionOfTwoSortedArray {
	public static void main(String[] args) {
		int[] arr1 = { 2, 5, 8, 8, 13, 15,15 };
		int[] arr2 = { 1, 3, 8, 8, 15, 15, 18, 20, 25 };
		method1(arr1, arr2);
		method2(arr1, arr2);
	}

	private static void method1(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			if (i > 0 && arr1[i] == arr1[i - 1]) {
				continue;
			} else {
				if (binarySearch(arr2, arr1[i], 0, arr2.length) == -1) {
					continue;
				} else {
					System.out.print(arr1[i] + " ");
				}
			}
		}
	}

	static int binarySearch(int[] arr, int value, int start, int end) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (arr[mid] == value) {
			return mid;
		} else if (arr[mid] > value) {
			return binarySearch(arr, value, start, mid - 1);
		} else {
			return binarySearch(arr, value, mid + 1, end);
		}
	}

	static void method2(int[] arr1, int[] arr2) {
		int i = 0, j = 0;
		System.out.println("method 2");
		while (i < arr1.length && j < arr2.length) {
			if(i>0 && arr1[i]== arr1[i-1]) {
				i++;
			}
			else if (arr1[i] == arr2[j]) {
				System.out.print(arr1[i]+" ");
				//rep = arr1[i];
				i++;
				j++;
			}
			else if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}

		}
	}
}
