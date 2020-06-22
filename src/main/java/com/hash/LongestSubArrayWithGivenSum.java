package com.hash;

import java.util.HashMap;

public class LongestSubArrayWithGivenSum {
	public static void main(String[] args) {
		// int[] arr = { 1, 2, 0, -3, 3, 4, 5, 6, 0 };
		int[] arr = { 8, 3, 1, 5, -6, 6, 2, 2 };
		int sum = 4;
		int num = 0;

		HashMap<Integer, Integer> h = new HashMap<>();
		h.put(arr[0], 0);
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i] + arr[i - 1];
			if (arr[i] == sum) {
				num = i + 1;
			}
			if (h.containsKey(arr[i] - sum)) {
				if (num < i - h.get(arr[i] - sum)) {
					num = i - h.get(arr[i] - sum);
				}
			} else {
				if (h.containsKey(arr[i])) {
					continue;
				} else {
					h.put(arr[i], i);
				}
			}
		}
		System.out.println("map >> " + num);
	}
}
