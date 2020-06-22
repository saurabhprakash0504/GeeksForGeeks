package com.searching;

public class FindSubArrayWithGivenSum {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 7, 5 };
		subarraySum(arr.length, 19, arr);
	}

	static void subarraySum(int n, int s, int[] arr) {

		int currSum = 0;
		int start = 0;
		int end = 0;
		while (start <= end) {
			//System.out.println("start >> " + start + " end >> " + end);
			//System.out.println("currsum >> " + currSum);
			if (currSum == s) {
				System.out.println((start + 1) + " " + (end));
				break;
			} else if (currSum < s) {
				if (end == arr.length) {
					System.out.println("not found");
					break;
				}
				currSum = currSum + arr[end];
				end++;
			} else if (currSum > s) {
				currSum = currSum - arr[start];
				start++;
			}
		}
	}
}
