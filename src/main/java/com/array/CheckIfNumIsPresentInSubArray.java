package com.array;

public class CheckIfNumIsPresentInSubArray {
	public static void main(String[] args) {
		method1();
	}

	static void method1() {
		int[] arr = { 1, 4, 20, 3, 10, 5 };
		int givenNum = -11;
		int sum = 0;
		int j = 0;
		int i = 0;
		while (j<=i && i<arr.length ) {
			if (sum < givenNum) {
				sum = sum + arr[i];
				i = i + 1;
				
			} else {
				sum = sum - arr[j];
				j++;
			}
			if (sum == givenNum) {
				System.out.println("found");
				return;
			}
			
		}
		System.out.println("NOT FOUUND");
	}

}
