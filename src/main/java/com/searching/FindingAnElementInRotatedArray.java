package com.searching;

public class FindingAnElementInRotatedArray {
	public static void main(String[] args) {
		method2();
	}

	static void method1(int[] arr) {
		int[] arr2 = sortArray(arr);
		System.out.println(binarySearch(arr2, 40, 0, arr.length - 1));
	}

	static int[] sortArray(int[] arr) {
		int[] temp = new int[arr.length];
		int max = 0;
		int min = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < arr[min]) {
				min = i;
			}
			if (arr[i] > arr[max]) {
				max = i;
			}
		}
		System.out.println("max >>" + max);
		System.out.println("min >> " + min);
		int j = 0;
		for (int i = min; i < temp.length; i++) {
			temp[j] = arr[i];
			j++;
		}
		for (int i = 0; i < min; i++) {
			temp[j] = arr[i];
			j++;
		}
		System.out.println("temp");
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		return temp;
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

	static void method2() {
		int[] arr = { 10, 20, 30, 36, 5, 6, 7, 8 };
		int value = 36;
		int pivotIndex = findingPivotElement(arr, 0, arr.length - 1);
		System.out.println("pivot >>" + pivotIndex);

		if (value > arr[0])
			System.out.println("value is presenet at " + binarySearch(arr, value, 0, pivotIndex));
		if (value < arr[0])
			System.out.println("value is presenet at " + binarySearch(arr, value, pivotIndex + 1, arr.length - 1));
	}

	private static int findingPivotElement(int[] arr, int start, int end) {
		int mid = start + (end - start) / 2;
		if (arr[mid] > arr[mid + 1]) {
			return mid;
		} else if (arr[0] > arr[mid]) {
			return findingPivotElement(arr, 0, mid - 1);
		} else {
			return findingPivotElement(arr, mid + 1, end - 1);
		}
	}
}
