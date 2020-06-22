package com.matrix;

public class MultiplyMatrix {
	public static void main(String[] args) {
		int[][] arr1 = { { 4, 8 }, { 0, 2 }, { 1, 6 } };
		int[][] arr2 = { { 5, 2 }, { 9, 4 } };
		multiplyMatrix(arr1.length, arr1[0].length, arr2.length, arr2[0].length, arr1, arr2);
	}

	static void multiplyMatrix(int n1, int m1, int n2, int m2, int arr1[][], int arr2[][]) {
		if (m1 == n2) {

			for (int i = 0; i < n1; i++) {
				for (int j = 0; j < m2; j++) {
					int mul = 0;
					for (int k = 0; k < m1; k++) {
						mul += arr1[i][k] * arr2[k][j];
					}
					System.out.print(mul + " ");
				}

			}
		}
	}
}
