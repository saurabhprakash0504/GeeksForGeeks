package com.sorting;

public class SegregateEvenAndOdd {
	public static void main(String[] args) {
		int[] arr= {15,14,12,13};
		segrete(arr);
	}

	static void segrete(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			while (arr[start] % 2 == 0) {
				start++;
			}
			while (arr[end] % 2 == 1) {
				end--;
			}
			System.out.println("start  >> "+start+ " end >> "+end);
			if(start<end)
			 swap(arr, start, end);
		}
		printing(arr);
	}

	private static void printing(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
}
