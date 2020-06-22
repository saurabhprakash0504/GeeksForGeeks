package com.bitoperator;

public class FindTheMissingNumber {
	public static void main(String[] args) {
		int[] a = {1,4,3};
		int actual=0;
		int given=0;
		for(int i=0;i<3;i++) {
			given=given^a[i];
		}
		for(int i=0;i<4;i++) {
			actual = actual^ (i+1);
		}
		System.out.println(actual ^ given);
	}
}
