package com.sorting;

import java.util.Iterator;
import java.util.LinkedHashSet;

class Intersection {
	/*
	 * Function prints Intersection of arr1[] and arr2[] n is the number of elements
	 * in arr1[] m is the number of elements in arr2[]
	 */
	static void printIntersection(int arr1[], int arr2[], int n, int m) {
		// add your code here
		int i = 0;
		int j = 0;
		LinkedHashSet<Integer> l = new LinkedHashSet<Integer>();
		while (i < n && j < m) {
			if (arr1[i] == arr2[j]) {
				l.add(arr1[i]);
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
		}
		Iterator<Integer> io =l.iterator();
		while(io.hasNext()) {
			System.out.print(io.next()+" ");
		}
	}

	public static void main(String[] args) {
		int[] arr1= {1,2,3,4};
		int[] arr2= {2,4,6,7,8};
		printIntersection(arr1, arr2, arr1.length, arr2.length);
	}
}
