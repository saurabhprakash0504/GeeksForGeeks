package com.hash;

import java.util.Arrays;
import java.util.HashSet;

public class PositiveNegativePair {
	public static void main(String[] args) {
		int[] arr = {1, -3, 1 ,-3, 5};
		method1(arr);
	}

	static void method1(int[] arr) {
		Arrays.sort(arr);
		HashSet<Integer> h = new HashSet<Integer>();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				h.add(arr[i]);
			} else {
				if (h.contains(-arr[i])) {
					sb.append(arr[i]);
					sb.append(-arr[i]);
				}
			}
		}
		System.out.println(sb.toString());
	}
}
