package com.array;

public class NBonacciNumber {
	public static void main(String[] args) {
		nBonacci(4, 10);
	}

	static void nBonacci(int n, int m) {
		int[] temp = new int[m];
		temp[n - 1] = 1;
		int i = 0;

		while (i < m - n) {
			int sum = 0;
			for (int j = i; j <= (i + n); j++) {
				sum = sum + temp[j];
			}
			temp[i + n] = sum;
			i = i + 1;
		}

		for (int ii = 0; ii < temp.length; ii++) {
			System.out.print(temp[ii] + " ");
		}
	}
}
