package com.hash;

import java.util.HashMap;
import java.util.HashSet;

public class CountDistinctElementInWindow {
	public static void main(String[] args) {
		int[] arr = { 10, 20,10,10,30,40};
		int k = 4;
		method1(arr, k);
		method2(arr, k);
	}

	private static void method1(int[] arr, int ii) {
		HashSet<Integer> h = new HashSet<>();
		for (int i = 0; i <= arr.length - ii; i = i + 1) {
			int j = 0;
			while (j < ii) {
				h.add(arr[i + j]);
				j++;
			}
			System.out.print(h.size() + " ");
			h.clear();
		}
		System.out.println();
	}

	private static void method2(int[] arr, int ii) {
		HashMap<Integer,Integer> h = new HashMap<>();

		for (int i = 0; i < ii; i++) {
			if(h.containsKey(arr[i]))
				h.put(arr[i],h.get(arr[i])+1);
			else
				h.put(arr[i], 1);
		}
		System.out.print(h.size() + " ");
		for (int i = ii; i < arr.length; i = i + 1) {
			if(1 == h.get(arr[i - ii])) {
				h.remove(arr[i - ii]);
			}else {
				h.put(arr[i - ii], h.get(arr[i - ii])-1);
			}
			if(h.containsKey(arr[i]))
				h.put(arr[i],h.get(arr[i])+1);
			else
				h.put(arr[i], 1);
			System.out.print(h.size() + " ");
		}

	}



}
