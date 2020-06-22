package com.bitoperator;

public class FindingFirstSetBit {
	public static void main(String[] args) {
		System.out.println(getFirstSetBitPos(2));
	}

	public static int getFirstSetBitPos(int n) {

		// Your code here
		int i = 0;
		while (true) {
			if ((n & (1 << i)) != 0) {
				return (i + 1);
			} else {
				i++;
			}
		}

	}
}
