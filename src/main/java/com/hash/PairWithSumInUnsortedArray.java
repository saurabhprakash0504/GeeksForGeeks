package com.hash;

import java.util.HashMap;
import java.util.HashSet;

public class PairWithSumInUnsortedArray {
	public static void main(String[] args) {
		int[] arr = { 11, 5, 5, 8, 5, 6 };
		int sum = 10;
		System.out.println(method2(arr, sum));
		System.out.println(findPair(arr, sum));
	}

	static boolean findPair(int[] arr, int sum) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (h.containsKey(i)) {
				h.put(i, h.get(i) + 1);
			} else {
				h.put(i, 1);
			}
		}
		for (int j : h.keySet()) {
			int diff = sum - j;
			if (diff == j) {
				if (h.get(diff) > 1) {
					return true;
				}
			} else if (h.containsKey(diff)) {
				return true;
			}

		}
		return false;
	}

	static boolean method2(int[] arr, int ele) {
		HashSet<Integer> s = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (s.contains(ele - arr[i])) {
				return true;
			} else {
				s.add(arr[i]);
			}
		}
		return false;
	}
}
