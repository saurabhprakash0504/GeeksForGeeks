package com.recurssion;

public class FindSumOfDigitMethod2 {
	public static void main(String[] args) {
		System.out.println(sumOfDigit(253));
	}
	
	static int sumOfDigit(int n) {
		if(n < 10) {
			return n;
		}
		return sumOfDigit(n/10)+ n%10;
	}
}
