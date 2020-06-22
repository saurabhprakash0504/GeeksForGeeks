package com.hash;

public class CountFrequency {
	public static void main(String[] args) {
		int[] arr = { 10, 12, 10, 15, 10, 20, 12, 12 };
		for (int i = 0; i < arr.length; i++) {
			int ele = arr[i];
			int count = 1;
			for (int k = 0; k < i; k++) {
				if (arr[k] == ele) {
					count = 2;
					break;
				}
			}
			if (count == 1) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] == ele) {
						count++;
					}
				}
				System.out.println(ele + " count " + count);
			}
		}
	}
}
