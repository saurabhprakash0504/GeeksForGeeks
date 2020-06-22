package com.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortingElementByFrequency {
	public static void main(String[] args) {
		int[] arr = {9 ,9, 9, 2, 5};
		sort(arr);
	}

	static void sort(int[] arr) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (h.containsKey(arr[i])) {
				h.put(arr[i], h.get(arr[i]) + 1);
			} else {
				h.put(arr[i], 1);
			}
			if (h.get(arr[i]) > max) {
				max = h.get(arr[i]);
			}
		}

		while (max > 0) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			for (Map.Entry<Integer, Integer> m : h.entrySet()) {

				if (m.getValue() == max) {
					a.add(m.getKey());
					//h.remove(m.getKey());
				}
			}
			Collections.sort(a);

			for (int j : a) {
				int i = 1;
				while (i <= max) {
					System.out.print(j+" ");
					i++;
				}
			}
			max--;
		}
	}
}
