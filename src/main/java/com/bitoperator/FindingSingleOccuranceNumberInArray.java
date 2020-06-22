package com.bitoperator;

public class FindingSingleOccuranceNumberInArray {
	
	// solution is same for single occurance 
	// below solution will work for the single element which occureed for the odd number of times
	public static void main(String[] args) {
		int[] a = { 3, 4, 2, 2, 2, 2, 3, 4, 4, 3, 4 };
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum ^ a[i];
		}
		System.out.println("sum >> " + sum);
	}
}
