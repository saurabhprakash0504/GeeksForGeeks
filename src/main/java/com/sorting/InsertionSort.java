package com.sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 7, 6, 5, 1, 1, 1, 2, 3 };
		insertionSortMethod2(arr);
		insertionSort(arr);
	}

	static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				for (int j = 0; j < i; j++) {
					if (arr[j] >= arr[i]) {
						move(j, i, arr);
					}
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void move(int j, int i, int[] arr) {
		int val = arr[i];
		for (int k = i; k > j; k--) {
			arr[k] = arr[k - 1];
		}
		arr[j] = val;
	}


	static void insertionSortMethod2(int[] arr) {

		for(int i=1;i<arr.length;i++) {
			int key=arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>=key) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
		System.out.println("method 2");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("method2 over");

	}
}