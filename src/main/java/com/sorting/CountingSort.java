package com.sorting;

import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args) {
		int[] arr = { 2, 5, 6, 5, 2 };
		int k = 7;
		countingSort(arr, k);
	}

	static void countingSort(int[] arr, int k) {
		int[] count = new int[k];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]] = count[arr[i]] + 1;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i - 1];
		}

		int[] temp=new int[arr.length];
		for(int i =temp.length-1;i>=0;i--) {
			temp[count[arr[i]]-1]=arr[i];
			count[arr[i]]--;
		}

		for(int i =0;i<temp.length;i++) {
			arr[i]=temp[i];
		}
		System.out.println(Arrays.toString(arr));
	}
}
