package com.searching;

public class FindLowestValueInSortedRotatedArray {

	public static void main(String[] args) {
		int[] arr = {8 ,10, 2 ,4 ,6};
		System.out.println(minNumber(arr, 0, arr.length-1));;
	}

	static long minNumber(int arr[], long low, long high) {

		if (arr[(int) high] < arr[(int) high - 1]) {
			return arr[(int) high];
		}
		int mid = (int) (low + high) / 2;
		if (low >= high) {
			return arr[mid];
		}

		if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
			return arr[mid];
		} else if (arr[mid] < arr[0]) {
			return minNumber(arr, low, mid - 1);
		} else {
			return minNumber(arr, mid + 1, high);
		}

	}

}
