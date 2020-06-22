package com.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
		int[] arr = {1,2,2,1,1,1,1};
		method1(arr);
		method3(arr);
	}

	static void method1(int[] arr) {
		int minValue = arr.length / 2;
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
				if (count > minValue) {
					System.out.println(arr[i] + " index " + i);
					return;
				}
			}
		}
	}

	static void method2(int[] arr) {
		LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
			} else {
				hashMap.put(arr[i], 1);
			}
		}
		int value = arr.length / 2;
		List<Integer> listKeys = new ArrayList<Integer>(hashMap.keySet());
		Iterator iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry) iterator.next();
			Integer mapValue = (Integer) mapElement.getValue();
			if (mapValue > value) {
				System.out.println("index > " + listKeys.indexOf(mapElement.getKey()));
				return;
			}
		}

	}

	// MooreseVotingAlgorithm
	static void method3(int[] arr) {
		// { 1, 8, 3, 4, 8, 8, 8 };
		int count = 1;
		int res = arr[0];
		int index = 0;
		int minLength = arr.length / 2;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == res) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				index = i;
				count = 1;
				res = arr[i];
			}
		}

		int counter = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == res)
				counter++;
		}
		if (counter > minLength) {
			System.out.println(res + " index >> " + index);
		}

	}

}
