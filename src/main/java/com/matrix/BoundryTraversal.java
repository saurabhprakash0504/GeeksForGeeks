package com.matrix;

public class BoundryTraversal {
	public static void main(String[] args) {
		int[][] arr = { { 1 }, { 2 }, { 3 }, { 4 } };
		boundaryTraversal(arr.length, arr[0].length, arr);
	}

	static void boundaryTraversal(int n1, int m1, int a[][]) {
		int top = 0;
		int right = a[0].length - 1;
		int left = 0;
		int bottom = a.length - 1;

		for (int i = 0; i < m1; i++) {
			System.out.print(a[top][i] + " ");
		}
		top++;

		for (int i = 1; i < n1; i++) {
			System.out.print(a[i][right] + " ");
		}
		right--;

		if (bottom >= top) {
			for (int i = m1 - 2; i >= 0; i--) {
				System.out.print(a[bottom][i] + " ");
			}
			bottom--;
		}

		if (right >= left) {
			for (int i = n1 - 2; i >= 1; i--) {
				System.out.print(a[i][left] + " ");
			}
			left++;
		}

	}
}
