package com.matrix;

public class TransposeOfMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		System.out.println("original matrix");
		print(matrix);
		int[][] newMatrix = new int[matrix[0].length][matrix.length];
		transpose(matrix, newMatrix);
		System.out.println("transposed matrix");
		print(matrix);
	}

	private static void transpose(int[][] matrix, int[][] newMatrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i+1; j < matrix[i].length; j++) {
					swap(matrix, i, j);
				// newMatrix[j][i] = matrix[i][j];
			}
		}
	}

	private static void swap(int[][] matrix, int i, int j) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = temp;
	}

	static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
