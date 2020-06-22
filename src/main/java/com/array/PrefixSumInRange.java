package com.array;

public class PrefixSumInRange {
	public static void main(String[] args) {
		method1();
	}

	static void method1() {
		int[] a = { 1, 2, 3 };
		int[] b = { 3, 5, 7 };

		int biggest = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] > biggest) {
				biggest = b[i];
			}
		}
		int temp[] = new int[biggest + 2];
		// System.out.println("temp"+temp.length);
		for (int i = 0; i < a.length; i++) {
			temp[a[i]] += 1;
			temp[b[i] + 1] -= 1;
		}
		int temp2[] = new int[biggest + 2];
		temp2[0] = temp[0];
		for (int i = 1; i < temp.length; i++) {
			temp2[i] = temp[i] + temp2[i - 1];
		}

		biggest = 0;
		for (int i = 0; i < temp2.length; i++) {
			if (temp2[i] > biggest) {
				biggest = temp2[i];
			}
		}

		System.out.println("biggest >> " + biggest);
	}
}
