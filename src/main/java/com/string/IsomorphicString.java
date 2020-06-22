package com.string;

public class IsomorphicString {
	public static void main(String[] args) {
		System.out.println(areIsomorphic("aab", "xxy"));
	}

	public static boolean areIsomorphic(String S1, String S2) {
		if (S1.length() != S2.length()) {
			return false;
		}
		int[] arr = new int[256];
		int[] arr2 = new int[256];
		for (int i = 0; i < S1.length(); i++) {
			if (arr[S1.charAt(i)]++ != arr2[S2.charAt(i)]++) {
				return false;
			}
		}
		return true;
	}
}
