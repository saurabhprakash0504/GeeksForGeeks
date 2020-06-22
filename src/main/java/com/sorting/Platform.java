package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

class Platform {
	static int findPlatform(int arr[], int dep[], int n) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int minValue = dep[0];
		a.add(minValue);
		int max = 1;
		for (int i = 1; i < n; i++) {
			//System.out.println(a);
			if (arr[i] > minValue) {
				if (max < a.size()) {
					max = a.size();
				}
//				for(int ip:a) {
//					if(ip<arr[i]) {
//						int index = a.indexOf(ip);
//						a.remove(index);
//					}
//				}
				Iterator<Integer> ig = a.iterator();
				while (ig.hasNext()) {
					int iq = ig.next();
					if (iq < arr[i]) {
						ig.remove();
					}
				}

				a.add(dep[i]);

				Collections.sort(a);
				minValue = a.get(0);
			} else {
				a.add(dep[i]);
			}
		}
		if (max < a.size()) {
			max = a.size();
		}
		return max;
	}

	static int method2(int[] arr, int[] dep,int n) {
		int[] temp= new int[dep[dep.length-1]+2];
		int max=0;
		for(int i=0;i<n;i++) {
			temp[arr[i]]++;
			temp[dep[i]+1]--;
		}
		System.out.println(Arrays.toString(temp));
		for(int i =1;i<temp.length;i++) {
			temp[i]+=temp[i-1];
			if(temp[i]>max) {
				max=temp[i];
			}
		}
		System.out.println(Arrays.toString(temp));
		return max;
	}

	public static void main(String[] args) {
		int[] arr = {9,11,14,15};
		int[] dep = {10,12,16,17};

		// int[] dep = {1000 ,1200 ,1240 };
		//System.out.println(findPlatform(arr, dep, arr.length));
		System.out.println(method2(arr, dep, arr.length));
	}

}