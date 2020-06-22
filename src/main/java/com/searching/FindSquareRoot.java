package com.searching;

public class FindSquareRoot {
	public static void main(String[] args) {
		System.out.println(findRoot(16, 1, 16));
	}

	static int findRoot(int n, int start, int end) {
		int mid = start + (end - start) / 2;
		if (n == mid * mid) {
			return mid;
		}
		if (start > end) {
			return end;
		} else if (n < mid * mid) {
			return findRoot(n, start, mid - 1);
		} else {
			return findRoot(n, mid + 1, end);
		}
	}

}
