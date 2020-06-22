package com.searching;

public class FloorQuestion {

	public static void main(String[] args) {
		int arr[] = {3223 ,3448, 9823, 2130, 7453, 4933, 5444, 6046};
		int n = arr.length;
		System.out.println(maxStep(arr, n));
	}

	static int maxStep(int arr[], int n) {

		// Your code here
		int count = 0;
		int maxCount = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				count = count + 1;
				 System.out.println("arr[i+1] >> "+arr[i+1]+ " arr[i] "+arr[i]);
				 System.out.println("count>>"+count);
			} else {
				if (maxCount <= count) {
					maxCount = count;
				}
				count = 0;
			}
		}
		if (maxCount <= count) {
			maxCount = count;
		}
		// System.out.println("maxCount >>"+maxCount);
		return maxCount;

	}

}
