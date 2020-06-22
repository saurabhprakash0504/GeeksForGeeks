package com.hash;

import java.util.HashSet;

public class IntersectionOfTwoArray {
	public static void main(String[] args) {
		//int[] arr1 = { 89, 24, 75, 11, 23 };
		//int[] arr2 = { 89, 2, 4 };
		int[] arr1 = {10, 10, 10};
		int[] arr2 = {10, 10, 10};
		method1(arr1, arr2);
	}

	static void method1(int[] arr1, int[] arr2) {
		HashSet<Integer> h = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			h.add(arr1[i]);
		}

		for (int i : arr2) {
			if (h.contains(i)) {
				System.out.println(i);
				h.remove(i);
			}
		}
	}
}
