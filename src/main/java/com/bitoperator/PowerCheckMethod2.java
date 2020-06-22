package com.bitoperator;

public class PowerCheckMethod2 {
	public static void main(String[] args) {
		int n = 1;
		if (n == 0) {
			System.out.println("no");
		}
		else if ((n & n - 1) == 0) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		
		System.out.println("pow "+isPow(1));

	}
	
	static boolean isPow(int n) {
		if( n ==0 ) {
			return false;
		}
		return ((n & (n-1))==0);
	}
}
