package com.searching;

public class FindMedianInAnArray {
	public static void main(String[] args) {
		int[] a1 = { 30, 40, 50, 60 };
		int[] a2 = { 5, 6, 7, 8, 9 };
		System.out.println(findMedian(a1, a2));
	}

	static double findMedian(int[] a1, int[] a2) {
		int n1 = a1.length;
		int n2 = a2.length;
		int beg1 = 0;
		int end1 = n1;
		double result = 0.0;
		while (beg1 <= end1) {
			int i1 = (beg1 + end1) / 2;
			int i2 = (n1 + n2 + 1) / 2 - i1;
			int min1 = (i1 == n1) ? Integer.MAX_VALUE : a1[i1];
			int max1 = (i1 == 0) ? Integer.MIN_VALUE : a1[i1 - 1];
			int min2 = (i2 == n2) ? Integer.MAX_VALUE : a2[i2];
			int max2 = (i2 == 0) ? Integer.MIN_VALUE : a2[i2 - 1];
			System.out.println("min1 ?? "+min1);
			System.out.println("max1 ?? "+max1);
			System.out.println("min2 ?? "+min2);
			System.out.println("max2 ?? "+max2);
			if (max1 <= min2 && max2 <= min1) {
				if ((n1 + n2) % 2 == 0) {
					result = ((double) Math.max(max1, max2) + Math.min(min1, min2)) / 2;
					return result;
				} else {
					result = Math.max(max1, max2);
					return result;
				}
			} else if (max1 > min2) {
				end1 = i1 - 1;
			} else {
				beg1 = i1 + 1;
			}
		}
		return result;
	}
}
