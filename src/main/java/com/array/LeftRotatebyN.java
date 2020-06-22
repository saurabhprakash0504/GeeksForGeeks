package com.array;

public class LeftRotatebyN {
	public static void main(String[] args) {
		method3();
	}

	static void method1() {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int rotate = 2;
		// expected {3,4,5,6,1,2}
		int[] temp = new int[rotate];
		for (int i = 0; i < rotate; i++) {
			temp[i] = arr[i];
		}
		for (int j = rotate; j < arr.length; j++) {
			arr[j - rotate] = arr[j];
		}

		for (int k = 0; k < rotate; k++) {
			arr[arr.length - rotate + k] = temp[k];
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	static void method2() {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int rotate = 4;
		for (int i = 1; i <= rotate; i++) {
			int temp = arr[0];
			for (int j = 1; j < arr.length; j++) {
				arr[j - 1] = arr[j];
			}
			arr[arr.length - 1] = temp;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	//best way
	static void method3() {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int rotate = 4;
		reverse(0, rotate - 1, arr);

		System.out.println("After first");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		reverse(rotate, arr.length - 1, arr);
		System.out.println("After Second");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		reverse(0, arr.length - 1, arr);

		System.out.println("After third");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	static void reverse(int start, int end, int[] arr) {
		int j = 0;
		for (int i = start; i <= (start + end) / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[end - j];
			arr[end - j] = temp;
			j++;
		}
	}
}
