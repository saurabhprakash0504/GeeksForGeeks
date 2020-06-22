package com.matrix;

public class PrintingBoundaryElement {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
		method1(arr);
	}

	static void method1(int[][] arr) {
		int noOfRow = arr.length;
		int noOfCol = arr[0].length;
		for (int i = 0; i < noOfCol; i++) {
			System.out.print(arr[0][i] + " ");
		}

		for (int i = 1; i < noOfRow; i++) {
			System.out.print(arr[i][noOfCol - 1] + " ");
		}

		if (noOfRow > 1) {
			for (int i = noOfCol - 2; i >= 0; i--) {
				System.out.print(arr[noOfRow - 1][i] + " ");
			}
		}

		if (noOfCol > 1) {
			for (int i = noOfRow - 2; i >= 1; i--) {
				System.out.print(arr[i][0] + " ");
			}
		}
	}
}
