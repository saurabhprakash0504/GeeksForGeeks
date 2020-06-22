package com.recurssion;

public class FindSumOfDigit {
	public static void main(String[] args) {
		System.out.println(sumOfDigit(9987, 0));
	}
	
	static int sumOfDigit(int n, int sum) {
		if(n == 0) {
			return sum;
		}
		int rem= n%10;
		sum=sum+rem;
		return sumOfDigit(n/10, sum);
	}
}
