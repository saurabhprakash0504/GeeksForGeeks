package com.array;

public class MaxLengthEvenOddSubArray {
	public static void main(String[] args) {
		method1();
	}
	
	static void method1() {
		int[] arr = {1,1,1,2,1,1,1};
		int prevVal=arr[0]%2;
	
		int max=1;
		int counter = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] % 2 == prevVal) {
				prevVal = arr[i] % 2;
				counter = 1;
			} else {
				counter++;
				if (counter > max) {
					max = counter;
				}
				prevVal = arr[i] % 2;
			}
		}
		System.out.println("max >> "+max);
	}
}
