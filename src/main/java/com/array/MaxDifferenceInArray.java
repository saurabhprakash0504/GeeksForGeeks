package com.array;

public class MaxDifferenceInArray {
	public static void main(String[] args) {
		method2();
	}

	static void method1() {
		int[] arr = { 2, 3, 10, 6, 4, 8, 1 };
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[j] - arr[i]) > max) {
					max = arr[j] - arr[i];
				}
			}
		}
		System.out.println("max >> " + max);
	}

	static void method2() {
		int[] arr = { 2, 3, 10, 19, 45, 4, 8, 1 };
		int maxVal = arr[1] - arr[0];
		int minNum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if ((arr[i] - minNum) > maxVal) {
				maxVal = arr[i] - minNum;
				if (minNum > arr[i]) {
					minNum = arr[i];
				}
			}
		}
		System.out.println("maxvalue >> " + maxVal);
	}
}
