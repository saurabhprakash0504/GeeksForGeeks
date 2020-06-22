package com.sorting;

import java.util.Arrays;

class Solution {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int j = 0;
		int i = m;
		while (i >= 0 && j <= n) {
			if (nums1[i] > nums2[j]) {
				int tem = nums1[i];
				nums1[i] = nums2[j];
				nums2[j] = tem;
				j++;
				i--;
			} else {
				break;
			}
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
	}

	public static void main(String[] args) {
		int[] arr1 = { 2, 6, 7, 8 };
		int[] arr2 = { 1, 4, 6, 8, 9 };
		merge(arr1, arr1.length - 1, arr2, arr2.length - 1);

	}
}