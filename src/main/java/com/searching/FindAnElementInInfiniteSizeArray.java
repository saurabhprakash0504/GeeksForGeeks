package com.searching;

public class FindAnElementInInfiniteSizeArray {
	public static void main(String[] args) {
			int[] arr = { -10, 10, 15, 44, 60, 80, 100 };
			findAnElement(arr, 1);
			
	}

	static int index = 1;

	static void findAnElement(int[] arr, int value) {
		
		if (arr[index] == value) {
			System.out.println(index); ;
		} else if (value < arr[index]) {
			System.out.println(binarySearch(arr, value, index/2, index));
		} else {
			index = index * 2;
			findAnElement(arr, value);
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
}
