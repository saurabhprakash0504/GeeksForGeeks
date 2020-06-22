package com.recurssion;

public class PrintingNumberUsingTailRecurssion {
	public static void main(String[] args) {
		printSeries(5,1);
	}
	
	static void printSeries(int n,int i) {
		if(n == 0) {
			return ;
		}
		System.out.println((n+i) - n);
		
		printSeries(n-1,i+1);
	}
}
