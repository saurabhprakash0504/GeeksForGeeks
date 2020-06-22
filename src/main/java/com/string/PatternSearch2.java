package com.string;

public class PatternSearch2 {
	public static void main(String[] args) {
		String input = "GeeksForGeeks";
		String pattern = "For";
		System.out.println(search2(input, pattern));
	}

	static int search2(String input, String pattern) {
		for (int i = 0; i <= input.length() - pattern.length(); i = i + 1) {
			if (input.charAt(i) == pattern.charAt(0)) {
				String s = input.substring(i, i + pattern.length());
				if (s.equals(pattern)) {
					return i;
				}
			}
		}
		return -1;
	}
}
