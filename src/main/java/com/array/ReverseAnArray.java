package com.array;

public class ReverseAnArray {
	public static void main(String[] args) {
		method2WithOutNewArray();

	}

	void method1WithNewArray() {
		int[] arr = { 10, 5, 7, 30 };
		int[] revArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			revArr[arr.length - (i + 1)] = arr[i];
		}
		// printing the revArray
		for (int i = 0; i < arr.length; i++) {
			System.out.println(revArr[i]);
		}
	}

	static void method2WithOutNewArray() {
		int[] arr = { 10, 5, 6, 7, 30 };
		for (int i = 0; i < arr.length / 2; i++) {

			int temp = arr[i];
			arr[i] = arr[arr.length - (1 + i)];
			arr[arr.length - (1 + i)] = temp;
		}
		// printing the revArray
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
