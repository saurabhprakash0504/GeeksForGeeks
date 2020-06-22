package com.hash;

public class LongestSubArrayWith0And1 {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 1, 1, 0, 1, 0, 0 };
		method1(arr);

	}

	static void method1(int[] arr) {
		int maxCount = 0;
		for (int i = 0; i < arr.length; i++) {
			int zero = 0;
			int one = 0;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] == 0) {
					zero++;
				} else {
					one++;
				}

				if (zero == one) {
					if ((zero + one) > maxCount) {
						maxCount = zero + one;
					}
				}
			}

		}
		System.out.println("maxCount >> " + maxCount);
	}
}
