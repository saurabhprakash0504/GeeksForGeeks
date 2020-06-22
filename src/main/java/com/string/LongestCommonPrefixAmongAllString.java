package com.string;

public class LongestCommonPrefixAmongAllString {
	public static void main(String[] args) {
		//String[] str = { "geeksforgeeks", "geeks", "geek", "geezer" };
		String[] str = {"apple" ,"ape" ,"april"};
		System.out.println(check(str));
	}

		static String check(String[] str) {
			String finalString = str[0];
			for (int i = 1; i < str.length; i++) {
				int n = 0;
				if (finalString.length() < str[i].length()) {
					n = finalString.length();
				} else {
					n = str[i].length();
				}
				int len=0;
				for (int j = 0; j < n; j++) {
					if (finalString.charAt(j) == str[i].charAt(j)) {
						len++;
					}else {
						break;
					}
				}
				finalString=finalString.substring(0,len);
			}
			return finalString;
		}
}
