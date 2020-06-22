package com.string;

public class SumOfInteger {
	public static void main(String[] args) {
		String s = "geeks4geeks";
		System.out.println(findSum(s));
	}

	public static long findSum(String s) {
		long num = 0;
		for (int i = 0; i < s.length(); i++) {
			int asci = s.charAt(i);
			String temp = "";
			if (asci >= 48 && asci <= 57) {
				temp = temp + s.charAt(i);
				int j = i + 1;
				while (j < s.length() && s.charAt(j) >= 48 && s.charAt(j) <= 57) {
					temp = temp + s.charAt(j);
					j++;
				}
				i = j;
				num = num + Long.parseLong(temp);
			}
		}
		return num;

	}
}
