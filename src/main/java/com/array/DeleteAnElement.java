package com.array;

public class DeleteAnElement {
	public static void main(String[] args) {
		int[] arr = { 3, 8, 12, 5, 6 };
		int elementToDelete = 6;

		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == elementToDelete) {
				index = i;
				break;
			}
		}
		int[] arr1 = new int[arr.length - 1];
		if (index != -1) {
			for (int i = index + 1; i < arr.length; i++) {
				arr[i - 1] = arr[i];
			}

			for (int i = 0; i < arr1.length; i++) {
				arr1[i] = arr[i];
			}
		} else {
			System.out.println("not found");
		}

		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
	}
}
