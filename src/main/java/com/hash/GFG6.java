package com.hash;
/*package whatever //do not write package name here */

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class GFG6 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
            int m = sc.nextInt();
			int arr2[] = new int[n];
				int arr1[] = new int[m];
			// int b[]= new int[m];

			// store the elements of first array into set
			for (int i = 0; i < n; i++) {
				arr2[i] = sc.nextInt();
			}

            for (int i = 0; i < m; i++) {
				arr1[i] = sc.nextInt();
			}

			relativeSorting(arr1,arr2);
}
	}

	static void relativeSorting(int[] arr1, int[] arr2) {
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		for(int i=0;i<arr1.length;i++) {
			if(h.containsKey(arr1[i])) {
				h.put(arr1[i], h.get(arr1[i])+1);
			}else {
				h.put(arr1[i], 1);
			}
		}
		int count=0;
		for(int i=0;i<arr2.length;i++) {
			int temp=h.get(arr2[i]);
			while(temp>0) {
				arr1[count]=arr2[i];
				count++;
				temp--;
			}
			h.remove(arr2[i]);
		}

		List l =Arrays.asList(h.keySet().toArray());

		Collections.sort(l);

		for(int i=0;i<l.size();i++) {
			int temp=h.get(l.get(i));
			while(temp>0) {
				arr1[count]=(int) l.get(i);
				count++;
				temp--;

			}
			h.remove(arr2[i]);
		}

		for(int i:arr1) {
			System.out.print(i+" ");
		}

	}
}