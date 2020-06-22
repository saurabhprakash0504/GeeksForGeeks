package com.sorting;

class Num_of_pair {
	// Function to count number of pairs of x, y
	// x[], y[]: input array elements
	// n, m: size of arrays x[] and y[] respectively
	static long countPairs(int x[], int y[], int n, int m) {
		// your code here
		long count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (Math.pow(x[i], y[j]) > Math.pow(y[j], x[i])) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 5 };
		int[] arr2 = { 1, 2, 3 };
		System.out.println(countPairs(arr, arr2, arr.length, arr2.length));
	}
}