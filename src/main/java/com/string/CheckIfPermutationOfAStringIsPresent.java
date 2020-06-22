package com.string;

public class CheckIfPermutationOfAStringIsPresent {
	public static void main(String[] args) {
		String input = "geeksforgeeks";
		String checkString = "esk";

		System.out.println(check(input, checkString));
	}

	private static boolean check(String input, String checkString) {
		int[] arr1 = new int[256];
		int[] arr2 = new int[256];
		for (int i = 0; i < checkString.length(); i++) {
			arr1[checkString.charAt(i)]++;
			arr2[input.charAt(i)]++;
		}
		if (areSame(arr1, arr2)) {
			return true;
		}
		for (int i = checkString.length(); i < input.length(); i++) {
			arr2[input.charAt(i - checkString.length())]--;
			arr2[input.charAt(i)]++;
			if (areSame(arr1, arr2)) {
				return true;
			}
		}
		return false;

	}

	static boolean areSame(int[] arr1, int[] arr2) {
		for (int i = 0; i < 256; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

}
