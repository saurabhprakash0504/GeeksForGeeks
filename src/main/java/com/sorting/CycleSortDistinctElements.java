package com.sorting;

import java.util.Arrays;

public class CycleSortDistinctElements {
	public static void main(String[] args) {
		int[] arr = { 40, 30, 20, 10, 70, 60 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	static void sort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int item = arr[i];
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] < item) {
					count++;
				}
			}
			item = arr[count];
			arr[count] = arr[i];
			while (count != i) {
				count = 0;
				for (int j = 0; j < arr.length; j++) {
					if (arr[j] < item) {
						count++;
					}
				}
				int item2 = arr[count];
				arr[count] = item;
				item = item2;
			}
		}
	}
}
