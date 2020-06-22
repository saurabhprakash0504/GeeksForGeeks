package com.string;

public class SmallestWindowContainingAllChar {
	public static void main(String[] args) {
		String s = "timetopractice";
		String pat = "toc";
		//String s = "abaaab";
		//String pat = "aabab";

		System.out.println(smallestWindow(s, pat));
	}

	static String smallestWindow(String text, String pattern) {
		if (text.length() < pattern.length()) {
			return "-1";
		}

		int[] arrPattern = new int[256];
		int[] arrText = new int[256];
		for (int i = 0; i < pattern.length(); i++) {
			arrPattern[pattern.charAt(i)]++;
		}

		int start = 0;
		int len = 0;
		int minLength = Integer.MAX_VALUE;
		int count = 0;

		int j = 0;

		while (j <= text.length() - 1) {
			while (count < pattern.length() && j < text.length()) {
				arrText[text.charAt(j)]++;
				if (arrPattern[text.charAt(j)] > 0 && arrText[text.charAt(j)] <= arrPattern[text.charAt(j)]) {
					count++;
				}
				j++;
			}

			while (arrText[text.charAt(start)] > arrPattern[text.charAt(start)]
					|| arrPattern[text.charAt(start)] == 0) {
				if (arrText[text.charAt(start)] > arrPattern[text.charAt(start)]) {
					arrText[text.charAt(start)]--;
				}
				start++;
			}
			len = j - start;
			minLength = Math.min(len, minLength);
		}
		return text.substring(start,start+minLength);

	}
}
