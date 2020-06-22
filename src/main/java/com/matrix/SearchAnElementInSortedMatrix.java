package com.matrix;

public class SearchAnElementInSortedMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 5, 6, 7, 8, 9 }, { 15, 16, 17, 18, 19 }, { 25, 26, 27, 28, 29 }, { 35, 36, 37, 38, 39 } };
		search(matrix, 39);
	}

	static void search(int[][] matrix, int ele) {
		int i = 0, j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == ele) {
				System.out.println("found " + i + " " + j);
				return;
			} else if (matrix[i][j] > ele) {
				j--;
			} else {
				i++;
			}
		}
		System.out.println("not found");
	}
}
