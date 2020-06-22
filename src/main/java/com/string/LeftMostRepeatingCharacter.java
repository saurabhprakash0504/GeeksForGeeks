package com.string;

import java.util.Arrays;

public class LeftMostRepeatingCharacter {
	public static void main(String[] args) {
		String s ="UpkYVLakIlrJHpnKnJlHlFyJiQTtumVmDARllqqnffOKkEJMuyAqlDEGblpdGSIpnPSgkMiTn";
		System.out.println(repeatedCharacter(s));
	}

	static int repeatedCharacter(String s) {
		int min = s.length();
		int[] arr = new int[256];
		Arrays.fill(arr, -1);
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			if (arr[val] == -1) {
				arr[val] = i;
			} else {
				min = Math.min(min, arr[val]);
			}
		}
		if (min == s.length()) {
			return -1;
		} else {
			return min;
		}
	}
}
