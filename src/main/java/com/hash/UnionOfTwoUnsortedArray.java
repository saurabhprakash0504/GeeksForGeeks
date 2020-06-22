package com.hash;

import java.util.HashSet;

public class UnionOfTwoUnsortedArray {
	public static void main(String[] args) {
		int[] arr1 = { 15, 20, 5, 15 };
		int[] arr2 = { 15, 15, 15, 20, 10 };
		HashSet<Integer> h = new HashSet<Integer>();
		for (int i : arr1) {
			h.add(i);
		}
		for (int i : arr2) {
			h.add(i);
		}

		System.out.println(h.size());

	}

}
