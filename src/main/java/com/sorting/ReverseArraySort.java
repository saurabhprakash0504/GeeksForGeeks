package com.sorting;

import java.util.Arrays;

public class ReverseArraySort {
	public static void main(String[] args) {
		int[] arr = {4,1,8,3,2,5,9};

		Arrays.sort(arr, 0, 5);
		System.out.println(Arrays.toString(arr));

		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));
	}
}
