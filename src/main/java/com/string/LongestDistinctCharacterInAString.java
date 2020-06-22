package com.string;

import java.util.Arrays;

public class LongestDistinctCharacterInAString {
	public static void main(String[] args) {
		String s = "abcbcda";
		System.out.println(longestLength(s));
	}

	static int longestLength(String s) {
		int start=0;
		int[] arr = new int[256];
		Arrays.fill(arr, -1);
		int maxLength=0;
		for(int i=0;i<s.length();i++) {
			start =Math.max(arr[s.charAt(i)]+1, start);
			int curr = i-start+1;
			maxLength = Math.max(curr, maxLength);
			arr[s.charAt(i)]=i;
		}
		return maxLength;
	}
}
