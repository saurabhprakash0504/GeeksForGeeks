package com.array;

public class MaxSumInRotatedSubArray {
	public static void main(String[] args) {
		// int[] arr = { 8, -8, 9, -9, 10, -11, 12 };
		// int[] arr = {10 ,-3, -4 ,7 ,6 ,5 ,-4, -1};
		// int[] arr = {-1, 40, -14, 7, 6, 5, -4, -1};
		int[] arr = { -8, -9, -11 };
		System.out.println(normalSubArray(arr));
	}

	static int normalSubArray(int[] arr) {
		int[] temp = new int[arr.length];
		temp[0] = arr[0];
		int arrSum = 0;
		arrSum += arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (temp[i - 1] + arr[i] > arr[i]) {
				temp[i] = temp[i - 1] + arr[i];
			} else {
				temp[i] = arr[i];
			}
			arrSum += arr[i];
		}

		int normalMax = Integer.MIN_VALUE;
		

		// for (int i = 0; i < temp.length; i++) {
		// System.out.print(temp[i] + " ");
		// }

		for (int i = 0; i < temp.length; i++) {
			if (normalMax < temp[i]) {
				normalMax = temp[i];
			}
		}
		if (normalMax < 0) {
			return normalMax;
		}

		int circularMin = Integer.MAX_VALUE;
		int[] temp2 = new int[arr.length];
		temp2[0] = arr[0];
		for (int ii = 1; ii < arr.length; ii++) {
			if (temp2[ii - 1] + arr[ii] < arr[ii]) {
				temp2[ii] = temp2[ii - 1] + arr[ii];
			} else {
				temp2[ii] = arr[ii];
			}
		}
		// System.out.println("temp2 ");
		// for (int i = 0; i < temp2.length; i++) {
		// System.out.print(temp2[i] + " ");
		// }

		for (int j = 0; j < temp2.length; j++) {
			if (circularMin > temp2[j]) {
				circularMin = temp2[j];
			}
		}

		int value = arrSum - circularMin;
		// System.out.println("vLUE>> " + value);
		return Math.max(value, normalMax);

	}
}
