package com.hash;

public class SubArrayWithProductLessThanK {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		subArray(arr, 10);
	}

	static void subArray(int[] arr, int pro) {
		String s = "";
		for (int i = 0; i < arr.length; i++) {
			s = s + arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			int k = 0;
			for (int j = i; j < arr.length; j++) {
				int kk = Integer.parseInt(s.substring(i, arr.length - k));
				int val = 1;
				while (kk != 0) {
					int rem = kk % 10;
					val = rem * val;
					kk = kk / 10;
				}
				if (val < pro) {
					System.out.println(s.substring(i, arr.length - k));
				}
				k++;
			}
		}
	}
}
