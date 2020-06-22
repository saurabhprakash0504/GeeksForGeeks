package com.hash;

import java.util.HashSet;

public class IntersectionOfTwoArrays {
	public static void main(String[] args) {
		int[] arr = { 10, 30, 30, 5 };
		int[] arr2 = { 30, 5, 30, 80 };

		HashSet<Integer> h = new HashSet<Integer>();
		for (int g : arr) {
			h.add(g);
		}
		int count = 0;
		for (int i : h) {
			for (int ii = 0; ii < arr2.length; ii++) {
				if (i == arr2[ii]) {
					count++;
					break;
				}
			}
		}
		System.out.println("count >> " + count);
	}
}
