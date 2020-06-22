package com.array;

public class LeadersInAnArray {
	public static void main(String[] args) {
		method2();
	}

	static void method1() {
		int[] arr = { 1,3,10,5,6,4,6,3};
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			int temp = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (temp <= arr[j]) {
					count = 0;
					break;
				}

			}
			if (count == 1) {
				System.out.print(arr[i]+" ");
			}
		}
	
	}
	
	static void method2() {
		int[] arr = { 1,3,10,5,6,4,6,3,1};
		int max=arr[arr.length-1];
		System.out.print(max+" ");
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i]> max) {
				System.out.print(arr[i]+" ");
				max=arr[i];
			}
		}
	}
}
