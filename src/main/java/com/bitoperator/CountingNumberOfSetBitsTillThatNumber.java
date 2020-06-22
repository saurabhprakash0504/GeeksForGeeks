package com.bitoperator;

public class CountingNumberOfSetBitsTillThatNumber {
	public static void main(String[] args) {
		System.out.println(countSetBits(3));
	}

	static int countSetBits(int n) {

		// Your logic here
		int counter = 0;
		for (int i = 1; i <= n; i++) {
			int ii = i;
			while (ii != 0) {
				ii = ii & (ii - 1);
				counter++;
			}

		}
		return counter;

	}
}
