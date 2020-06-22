package com.searching;

public class FindSquareRoots {
	public static void main(String[] args) {
		long i = 16;
		System.out.println(test(2));
	}

	static long test(long x) {
		long beg = 0;
		long end = x;
		long ans = 0;
		while (beg <= end) {
			long mid = beg + (end - beg) / 2;
			if (mid * mid == x) {
				return mid;
			} else if (x < mid * mid) {
				end = mid - 1;
			} else {
				ans = mid;
				beg = mid + 1;

			}
		}
		return ans;

	}
}
