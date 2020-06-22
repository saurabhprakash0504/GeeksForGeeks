package com.string;

public class RotationOfAString {
	public static void main(String[] args) {
		String a = "aaba";
		String b = "abaa";
		System.out.println(checkIfRotation(a, b));
	}

	static boolean checkIfRotation(String a, String b) {
		if (a.length() != b.length())
			return false;
		a = a + a;
		return a.contains(b);
	}
}
