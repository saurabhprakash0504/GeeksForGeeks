package com.string;

import java.util.HashSet;

class Repeatation {

	public static void main(String[] args) {
		String s = "llxxyyzz";
		System.out.println(nonrepeatingCharacter(s));
		System.out.println(nonrepeatingCharacter2(s));
	}

	static char nonrepeatingCharacter(String S) {
		int[] arr = new int[256];
		for (int i = 0; i < S.length(); i++) {
			int c = S.charAt(i);
			arr[c]++;
		}

		for (int i = 0; i < S.length(); i++) {
			if (arr[S.charAt(i)] == 1) {
				return S.charAt(i);
			}
		}
		return '$';
	}

	private static char nonrepeatingCharacter2(String S) {
		HashSet<Character> h= new HashSet<>();
		int[] arr = new int[256];
		for (int i = 0; i < S.length(); i++) {
			int c = S.charAt(i);
			arr[c]++;
			if(arr[c]>1) {
				h.remove(arr[c]);
			}

		}

		for (int i = 0; i < S.length(); i++) {
			if (arr[S.charAt(i)] == 1) {
				return S.charAt(i);
			}
		}
		return '$';

	}

}
