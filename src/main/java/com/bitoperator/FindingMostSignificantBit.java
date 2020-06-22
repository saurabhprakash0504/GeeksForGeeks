package com.bitoperator;

public class FindingMostSignificantBit {
	public static void main(String[] args) {
		int num =18;
		int big= num;
		 int k = (int)(Math.log(num) / Math.log(2));
		 System.out.println("k >>>"+k);
		while(num != 0) {
			big = num;
			num = num & (num -1);
		}
		System.out.println("num >> "+big);
	}
}
