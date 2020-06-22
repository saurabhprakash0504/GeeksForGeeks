package com.sorting;

public class UnionOfTwoArray {
	public static void main(String[] args) {
		int[] arr1 = { 2, 4, 5, 8, 8, 13, 15, 15 };
		int[] arr2 = { 1, 3, 8, 8, 15, 15, 18, 20, 25, 25 };
		method2(arr1, arr2);
	}

	static void method2(int[] arr1, int[] arr2) {
		int i = 0, j = 0;
		int firstLength = arr1.length;
		int secondLength = arr2.length;
		while (i < arr1.length && j < arr2.length) {
			if (i > 0 && arr1[i] == arr1[i - 1]) {
				i++;
				// continue;
			}
			if (j > 0 && arr2[j] == arr2[j - 1]) {
				j++;
				continue;
			} else if (arr1[i] == arr2[j]) {
				System.out.print(arr1[i] + " ");
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				System.out.print(arr1[i] + " ");
				i++;
			} else {
				System.out.print(arr2[j] + " ");
				j++;
			}

		}

		while (i < firstLength) {
			if (i > 0 || arr1[i] != arr1[i - 1]) {
				System.out.print(arr1[i] + " ");
				i++;
			}
		}

		// copying rest of the element
		while (j < secondLength) {
			if (j > 0 || arr2[j] != arr2[j - 1]) {
				System.out.print(arr2[j] + " ");
				j++;
			}
		}
	}
}
