package com.searching;

public class FindMedianInBetween2Array {
	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 4, 5 };
		int[] a2 = { 3, 4, 5, 6, 7, 8 };
		int n1 = a1.length;
		int n2 = a2.length;
		int i1 = n1 / 2;
		int i2 = (n1 + n2 + 1) / 2 - i1;

		while (i1 != -1 || i1 != a1.length) {
			int max1 = (i1 == 0) ? Integer.MIN_VALUE : a1[i1 - 1];

			// If i1 is equal to size of array1 then assign it to INT_MAX
			// else it will equal to a[i1] as array is sorted
			int min1 = (i1 == n1) ? Integer.MAX_VALUE : a1[i1];

			// Below we have max2 and min2 which we get from
			// array2 by dividing it into two parts

			// If i2 is zero then assign it to INT_MIN
			// else it will equal to b[i2-1] as array is sorted
			int max2 = (i2 == 0) ? Integer.MIN_VALUE : a2[i2 - 1];

			// If i2 is equal to size of array2 then assign it to INT_MAX
			// else it will equal to b[i2] as array is sorted
			int min2 = (i2 == n2) ? Integer.MAX_VALUE : a2[i2];

			if (max1 < min2 && min1 > max2) {
				if ((n1 + n2) % 2 == 1) {
					System.out.println("min1 " + Math.max(max1, max2));
					break;
				} else {
					System.out.println("value " + (Math.max(max1, max2) + Math.min(min1, min2)) / 2);
					break;
				}
			} else if (min1 < max2) {
				i1 = i1 + 1;
				i2 = i2 - 1;

			} else {
				i1 = i1 - 1;
				i2 = i2 + 1;
			}
		}

	}
}
