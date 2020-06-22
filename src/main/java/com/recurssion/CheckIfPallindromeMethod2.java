package com.recurssion;

public class CheckIfPallindromeMethod2 {
	public static void main(String[] args) {
		System.out.println(checkPallindrome("aabcaa"));
	}

	static boolean checkPallindrome(String input) {
		if (input.length() == 0 || input.length() == 1) {
			return true;
		}
		if (input.charAt(0) != input.charAt(input.length() - 1)) {
			return false;
		}
		return checkPallindrome(input.substring(1, input.length() - 1));
	}
}
