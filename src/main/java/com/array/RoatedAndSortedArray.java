package com.array;

public class RoatedAndSortedArray {

	public static void main(String[] args) {
		int[] arr = {30 ,20 ,10 ,50 ,25};
		System.out.println(checkRotatedAndSorted(arr, arr.length));
	}

	static boolean checkRotatedAndSorted(int arr[], int n) {

		// Your code here
		int max = 0;
		int maxValue=0;
		int min = 0;
		int minValue=0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > arr[max]) {
				max = i;
			}
			if (arr[i] < arr[min]) {
				min = i;
			}
		}
		if (max - 1 == min) {
			// int[] temp=new int[n];
			for (int i = 0; i < n - 1; i++) {
				if (arr[((max) + i) % n] > arr[((max + 1) + i) % n]) {
					continue;
				} else {
					return false;
				}

			}
			return true;

		} else if (max + 1 == min) {
			//System.out.println("max +1 >>"+(max+1));
			for (int i = 0; i < n - 1; i++) {
			//	System.out.println("max + 1 - i  >> "+(max + 1 + i));
			//	System.out.println("max + 2 - i  >> "+(max + 2 + i));
				if (arr[((max + 1) + i) % n] < arr[((max + 2) + i) % n]) {
					continue;
				} else {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
		// return true;
	}
}
