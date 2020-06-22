package com.matrix;

public class SpiralMatrix2 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		spirallyTraverse(arr[0].length, arr.length, arr);

	}

	static void spirallyTraverse(int m1, int n1, int a[][]) {
		int top = 0;
		int right = a[0].length - 1;
		int left = 0;
		int bottom = a.length - 1;
		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++) {
				System.out.print(a[top][i] + " ");
			}
			top++;

			for (int i = top; i <= bottom; i++) {
				System.out.print(a[i][right] + " ");
			}
			right--;

			if (bottom >= top) {
				for (int i = right; i >= left; i--) {
					System.out.print(a[bottom][i] + " ");
				}
				bottom--;
			}

			if (right >= left) {
				for (int i = bottom; i >= top; i--) {
					System.out.print(a[i][left] + " ");
				}
				left++;
			}

		}

	}
}
