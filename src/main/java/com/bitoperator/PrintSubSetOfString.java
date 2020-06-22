package com.bitoperator;

public class PrintSubSetOfString {
	public static void main(String[] args) {
		printSubSet("abc");
	}

	static void printSubSet(String input) {
		double d = Math.pow(2, input.length());
		int ii = (int) d;
		int k = ii - 1;
		for (int i = 0; i <= k; i++) {
			
			for(int kk=0;kk<input.length();kk++) {
				if((i & 1<<kk) != 0) {
					System.out.print(input.charAt(kk));
				}
			}
			System.out.println();
		}

	}
}
