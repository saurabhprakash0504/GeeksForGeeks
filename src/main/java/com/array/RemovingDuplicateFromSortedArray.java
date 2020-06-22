package com.array;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemovingDuplicateFromSortedArray {
	public static void main(String[] args) {
		method2();
	}

	static void method1UsingHashSet() {
		int[] arr = { 10, 20, 20, 30, 30, 30 };
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			hashSet.add(arr[i]);
		}
		System.out.println(hashSet);
		Iterator<Integer> ii = hashSet.iterator();
		int j = 0;
		while (ii.hasNext()) {
			arr[j] = ii.next();
			j++;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	static void method2() {
		int[] arr = { 10, 20, 20, 30, 30, 30 };
		int res = 1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]!=arr[res-1]) {
				arr[res]=arr[i];
				res++;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
