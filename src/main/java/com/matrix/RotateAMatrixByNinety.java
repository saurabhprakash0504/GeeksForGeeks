package com.matrix;

import java.util.Arrays;

public class RotateAMatrixByNinety {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		// method1(matrix);
		method2(matrix);
	}

	private static void method2(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				swap(matrix, i, j);
			}
		}

		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				swap2(matrix, i, j);
			}
		}

		System.out.println(Arrays.deepToString(matrix));
	}

	private static void swap2(int[][] matrix, int i, int j) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[matrix.length - (1 + i)][j];
		matrix[matrix.length - (1 + i)][j] = temp;
	}

	static void swap(int[][] matrix, int i, int j) {
		int temp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = temp;
	}

	static void method1(int[][] matrix) {
		rotate(matrix);
	}

	static void rotate(int[][] matrix) {
		int[][] newmatrix = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				newmatrix[i][j] = matrix[j][matrix.length - (i)];
			}
		}
		System.out.println(Arrays.deepToString(newmatrix));
	}

}
