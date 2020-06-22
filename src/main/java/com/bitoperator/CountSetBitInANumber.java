package com.bitoperator;

public class CountSetBitInANumber {
	public static void main(String[] args) {
		int num = 1;
		int counter=0;
		while(num != 0) {
			num = (num & (num -1));
			counter++;
		}
		System.out.println("counter >> "+counter);
	}
}
