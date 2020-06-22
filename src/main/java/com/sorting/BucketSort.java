package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
	public static void main(String[] args) {
		int[] arr = { 20, 88, 70, 85, 75, 95, 18, 82, 60 };
		System.out.println("input >>  "+Arrays.toString(arr));
		bucketSort(arr, 5);
	}

	static void bucketSort(int[] arr, int k) {
		int max = findMax(arr);
		ArrayList<ArrayList<Integer>> list = new ArrayList<>(k);

		for (int i = 0; i < k; i++) {
			list.add(new ArrayList());
		}

		for (int i = 0; i < arr.length; i++) {
			int bi = (k * arr[i]) / (max + 1);
			ArrayList l;
			l = list.get(bi);
			l.add(arr[i]);
			// list.set(bi, l);
		}

		for (int i = 0; i < list.size(); i++) {
			ArrayList kk = list.get(i);
			Collections.sort(kk);
			list.set(i, kk);
		}

		int kk=0;
		for (int i = 0; i < list.size(); i++) {
			for(int j=0;j<list.get(i).size();j++) {
				arr[kk]=list.get(i).get(j);
				kk++;
			}

		}

		System.out.println("Arrays >> "+Arrays.toString(arr));
	}

	private static int findMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = max > arr[i] ? max : arr[i];
		}
		return max;
	}
}
