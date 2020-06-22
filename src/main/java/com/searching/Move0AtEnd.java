package com.searching;

public class Move0AtEnd {
	public static void main(String[] args) {
		int[] arr = { 6, 5, 4, 0, 9, 0, 1, 2, 0 };
		moveEnd(arr);
	}

	static void moveEnd(int[] arr) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[counter] = arr[i];
				counter++;
			}
		}
		for (int i = counter + 1; i < arr.length; i++) {
			arr[i] = 0;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
