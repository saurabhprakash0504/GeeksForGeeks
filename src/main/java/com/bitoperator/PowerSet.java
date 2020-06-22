package com.bitoperator;

public class PowerSet {
	public static void main(String[] args) {
		String num = "abc";
		double pow = Math.pow(num.length(), 2);
		for (int i = 0; i < pow; i++) {

			for (int j = 0; j < num.length(); j++) {

				if ((i & (1 << j)) != 0) {
					System.out.print(num.charAt(j));
				}

			}
			System.out.println();
		}
	}
}
