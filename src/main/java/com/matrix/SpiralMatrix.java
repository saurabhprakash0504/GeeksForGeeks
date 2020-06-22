package com.matrix;

public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 } };
		printSpiral(matrix);
	}

	public static void printSpiral(int[][] matrix) {
		int top = 0;
		int right = matrix[0].length - 1;
		int bottom = matrix.length - 1;
		int left = 0;
		while (left <= right && top <= bottom) {
			for (int i = left; i <= right; i++) {
				System.out.print(matrix[top][i] + " ");
			}
			top++;

			for (int i = top; i <= bottom; i++) {
				System.out.print(matrix[i][right] + " ");
			}
			right--;

			if(top<=bottom) {
			for (int i = right; i >= left; i--) {
				System.out.print(matrix[bottom][i] + " ");
			}
			bottom--;
			}

			if(left<=right) {
			for (int i = bottom; i >= top; i--) {
				System.out.print(matrix[i][left] + " ");
			}
			left++;
			}
		}
	}
}
