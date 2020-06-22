package com.string;

public class PatternSearch {
	public static void main(String[] args) {
		String input = "geegsforgeeks";
		String pattern = "gsforgeeks";
		System.out.println(search2(input, pattern));
	}

	static boolean search(String input, String pattern) {
		while (input.indexOf(pattern.charAt(0)) != -1) {
			int i = input.indexOf(pattern.charAt(0));
			if (i + pattern.length() <= input.length() && input.substring(i, i + pattern.length()).equals(pattern)) {
				return true;
			}
			input = input.substring(i + 1, input.length());
		}
		return false;
	}

	static boolean search2(String input, String pattern) {
		for (int i = 0; i <= input.length() - pattern.length();) {
			if (input.charAt(i) == pattern.charAt(0)) {
				String s = input.substring(i, i + pattern.length());
				if (s.equals(pattern)) {
					return true;
				}
				i = i + pattern.length();
			} else {
				i = i + 1;
			}
		}
		return false;
	}
}
