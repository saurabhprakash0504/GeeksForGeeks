package com.array;

public class FindingMaxCons1 {
	public static void main(String[] args) {
		method1();
	}

	static void method1() {
		int[] arr = { 1, 0, 1, 1, 1, 1, 0,  1, 1, 1 };
		int counter = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				counter++;
				if (counter > max) {
					max = counter;
				}
			} else {
				counter = 0;
			}
		}

		// if(counter > max)
		// max=counter;
		System.out.println(max);
	}
}
