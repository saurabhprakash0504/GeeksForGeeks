package com.string;

public class ModifiedStringJava {
	public static void main(String[] args) {
		String a ="aabbbcc";
		System.out.println(modified(a));
	}

	public static long modified(String a) {
		long count = 0;
		char curr = a.charAt(0);
		int currCount = 1;
		for (int i = 1; i < a.length(); i++) {
			if (a.charAt(i) == curr) {
				currCount++;
				if (currCount == 3) {
					count = count + 1;
					currCount = 1;
				}
			} else {
				curr = a.charAt(i);
				currCount = 1;
			}

		}
		return count;
	}
}
