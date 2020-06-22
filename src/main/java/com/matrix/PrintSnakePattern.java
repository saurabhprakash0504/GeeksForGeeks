package com.matrix;

public class PrintSnakePattern {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printing(arr);
	}

	static void printing(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i % 2 == 0) {
					System.out.print(arr[i][j] + " ");
				} else {
					System.out.print(arr[i][(arr[i].length - j)-1] + " ");
				}
			}
		}
	}
}
