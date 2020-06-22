package com.bitoperator;

public class PowerCheck {
	public static void main(String[] args) {
		int n = 6;
		int k = 0;
		int i = 0;
		if ((n & 1) == 1) {
			System.out.println("no");

		} else {
			while (n != 0) {
				if ((n & 1) == 1) {
					k = k + 1;
				}
				n = n >> 1;
			}
			if (k == 1 || k == 0) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
