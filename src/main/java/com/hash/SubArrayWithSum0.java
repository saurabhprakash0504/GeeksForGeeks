package com.hash;

import java.util.LinkedHashSet;

public class SubArrayWithSum0 {
	public static void main(String[] args) {
		// int[] arr = { 1, 4, 13, -3, -10, 5, 0 };
		int[] arr = { 13, -4, -9, 0, 20 };
		LinkedHashSet<Integer> h = new LinkedHashSet<Integer>();
		int lastSum = 0;
		for (int i = 0; i < arr.length; i++) {

			lastSum = lastSum + arr[i];
			if (arr[i] == 0) {
				System.out.println("found at index >> " + i);
				h.add(lastSum);
				continue;
			}
			if (h.contains(lastSum)) {
				int index = 0;
				for (int j : h) {
					index++;
					if (j == lastSum) {
						System.out.println("start index " + index + " end index " + i);
						continue;
					}
				}

			}
			if (lastSum == 0) {
				System.out.println("found from 0 till " + i);
			}
			h.add(lastSum);
		}
	}
}
