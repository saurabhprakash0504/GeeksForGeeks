package com.sorting;

import java.util.Arrays;

public class MegeOverlappingInterval {
	public static void main(String[] args) {
		// int[][] matrix = { { 6, 10 }, { 1, 3 }, { 2, 4 }, { 7, 15 } };
		int[][] matrix = { { 5, 10 }, { 2, 3 }, { 6, 8 }, { 1, 7 } };
		// method1(matrix);
		method2(matrix);
	}

	static void method1(int[][] arr) {
		int big = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][1] > big) {
				big = arr[i][1];
			}
		}

		int[] temp = new int[big + 1];

		for (int i = 0; i < arr.length; i++) {

			for (int j = arr[i][0]; j < arr[i][1]; j++) {
				temp[j] = 1;
			}
		}

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 1) {
				System.out.print(i + ",");
				int start = i + 1;
				while (start < arr.length || temp[start] != 0) {
					start++;
				}
				System.out.println(start);
				i = start;
			}
		}

	}

	static void method2(int[][] arr) {
		Arrays.sort(arr, (a1, a2) -> a1[0] - a2[0]);
		System.out.println(Arrays.deepToString(arr));
		int res = 0;
		for (int i = 1; i < arr.length; i++) {

			if (arr[i][0] > arr[res][0] && arr[i][0] < arr[res][1]) {
				arr[res][0] = Math.min(arr[res][0], arr[i][0]);
				arr[res][1] = Math.max(arr[res][1], arr[i][1]);
			} else {
				res++;
				arr[res][0] = arr[i][0];
				arr[res][1] = arr[i][1];
			}
		}
		for (int i = 0; i <= res; i++)
			System.out.println(arr[i][0] + " , " + arr[i][1]);
	}
}
