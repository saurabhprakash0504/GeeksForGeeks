package com.string;

import java.util.HashMap;

public class MinimumWindowSubString {
	public static void main(String[] args) {
		String a="aaatatoyyocdt";
		String b="toc";
		System.out.println(findMin(a, b));

	}

	static int findMin(String text, String pattern) {
		int lenText = text.length();
		int lenPattern = pattern.length();
		if (lenPattern > lenText) {
			return -1;
		}
		HashMap<Character, Integer> hashPattern = new HashMap<Character, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (hashPattern.containsKey(c))
				hashPattern.put(c, hashPattern.get(c) + 1);
			else
				hashPattern.put(c, 1);
		}
		int start = 0;
		int count = 0;
		HashMap<Character, Integer> hashText = new HashMap<Character, Integer>();
		int j = 0;
		int minLength = Integer.MAX_VALUE;
		while (start < lenPattern) {
			while (count != lenPattern && j < lenText) {
				char d = text.charAt(j);
				if (hashText.containsKey(d)) {
					hashText.put(d, hashText.get(d) + 1);
				} else {
					hashText.put(d, 1);
				}
				if (hashPattern.containsKey(d) && hashPattern.get(d) >= hashText.get(d)) {
					count++;
				}
				j++;
			}

			while((hashPattern.get(text.charAt(start)) > hashText.get(text.charAt(start)))|| start<j) {
				char d = text.charAt(start);
				if (hashPattern.containsKey(d)) {
					if (hashPattern.get(d) < hashText.get(d)) {
						hashText.put(d, hashText.get(d) - 1);
					}
				} else {
					hashText.remove(d);
				}
				start++;
			}
				if (hashPattern.equals(hashText)) {
					int len = j - start - 1;
					minLength = Math.min(len, minLength);
					start = j;
			}
			if(j==lenText) {
				return minLength;
			}
		}
		return minLength;
	}
}
