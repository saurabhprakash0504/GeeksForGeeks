package com.hash;
/*package whatever //do not write package name here */

import java.util.HashMap;
import java.util.Scanner;

class GFG {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();

			int arr[] = new int[n];
			// int b[]= new int[m];

			HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
			int count = 0;

			// store the elements of first array into set
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			int prev = 0;
			for (int i = 0; i < n; i++) {
				int curr = prev + arr[i];
				if (curr == 0) {
					count++;
				}
				// if(s.contains(arr[i])){
				// count++;
				// }

				if (s.containsKey(curr)) {
					count = count + s.get(curr);
					s.put(curr, s.get(curr) + 1);
				} else {
					s.put(curr, 1);
				}
				prev = curr;

			}
			System.out.println(count);
		}
	}
}