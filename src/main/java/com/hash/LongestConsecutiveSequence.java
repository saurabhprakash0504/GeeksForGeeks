package com.hash;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		System.out.println(method1(arr));
		System.out.println("second "+method2(arr));
	}

	static int method1(int[] arr) {
		int max = 1;
		Arrays.sort(arr);
		int curr = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - 1 == arr[i - 1]) {
				curr++;
			} else {
				if (max < curr) {
					max = curr;
				}
				curr = 1;
			}
		}
		if (max < curr) {
			max = curr;
		}

		return max;
	}

	static int method2(int[] arr) {
		HashSet<Integer> h = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			h.add(arr[i]);
		}

		int maxCount = 0;
		int curr = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!h.contains(arr[i] - 1)) {
				curr = 1;
				int j = 1;
				while (h.contains(arr[i] + j)) {
					j++;
					curr++;
				}
			}
			maxCount = Math.max(maxCount, curr);
		}
		return maxCount;
	}
}
