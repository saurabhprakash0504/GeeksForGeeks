package com.array;

public class MaxSumCircularSubArray {
	public static void main(String[] args) {
		method1();
		method2();
	}

	static void method1() {
		int[] arr = { 5, -2, 3, 4 };
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int curr = 0;
			for (int j = i; j < (arr.length + i); j++) {
				int temp;
				temp = arr[j % (arr.length)];

				curr = curr + temp;
				if (curr > max) {
					max = curr;
				}
			}
		}
		System.out.println("max >> " + max);
	}

	static void method2() {
		int[] arr = { -5, -2, -3, -4 };
		int max_Normal = findMaxInNormalArray(arr);
		if(max_Normal < 0) {
			System.out.println("max normal "+max_Normal);
			return;
		}
		int arr_sum=0;
		for(int i =0 ;i<arr.length;i++) {
			arr_sum= arr_sum+ arr[i];
			arr[i]=-arr[i];
		}
		
		int maXCircular = arr_sum + findMaxInNormalArray(arr);
		System.out.println(Integer.max(max_Normal, maXCircular));
	}

	static int findMaxInNormalArray(int[] arr) {
		int[] temp = new int[arr.length];
		temp[0] = arr[0];
		int max = temp[0];
		for (int i = 1; i < arr.length; i++) {
			if ((temp[i - 1] + arr[i]) > arr[i]) {
				temp[i] = temp[i - 1] + arr[i];
			} else {
				temp[i] = arr[i];
			}
			if (temp[i] > max) {
				max = temp[i];
			}
		}
		return max;
	}
}
