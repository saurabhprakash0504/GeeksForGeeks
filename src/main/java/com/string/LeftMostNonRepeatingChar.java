package com.string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LeftMostNonRepeatingChar {
	public static void main(String[] args) {
		// String s = "geeksforgeeks";
		String s = "abcabcd";
		System.out.println(findLeft(s));
		System.out.println(method2(s));
		System.out.println(method3(s));

	}

	private static int findLeft(String s) {
		LinkedHashMap<Character, Integer> h = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (h.containsKey(s.charAt(i))) {
				h.remove(s.charAt(i));
			} else {
				h.put(s.charAt(i), i);
			}
		}
		for (Map.Entry<Character, Integer> m : h.entrySet()) {
			return m.getValue();
		}
		return -1;
	}

	private static int method2(String s) {
		LinkedHashSet<Character> h = new LinkedHashSet<Character>();
		for (char c : s.toCharArray()) {
			if (h.contains(c)) {
				h.remove(c);
			} else {
				h.add(c);
			}
		}
		for (char c : h) {
			return s.indexOf(c);
		}
		return -1;
	}

	private static int method3(String s) {
		int[] arr = new int[256];
		Arrays.fill(arr, -1);
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i);
			if (arr[index] == -1) {
				arr[index] = i;
			} else {
				arr[index] = -2;
			}
		}
		int small = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0 && arr[i]>small) {
				small = arr[i];
			}
		}
		return small;
	}
}
