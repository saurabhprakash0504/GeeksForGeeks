package com.sorting;

public class CloserToSort {
	public static void main(String[] args) {
		int[] arr = { 3, 2, 10, 4, 40 };
		System.out.println("elemenet >> " + search(arr, 40));
	}

	static int search(int[] arr, int ele) {
		int start = 0;
		int end = arr.length - 1;
		int index = -1;
		if (arr[end] == ele) {
			return end;
		}
		if (arr[start] == ele) {
			return start;
		}

		while ((start) <= (end)) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == ele) {
				System.out.println("found " + mid);
				index = mid;
				break;
			} else if (mid - 1 != -1 && arr[mid - 1] == ele) {
				System.out.println("found " + (mid - 1));
				index = mid - 1;
				break;
			} else if ((mid + 1) != arr.length && arr[mid + 1] == ele) {
				System.out.println("found " + (mid + 1));
				index = mid + 1;
				break;
			} else if (arr[mid] > ele) {
				end = mid - 2;
			} else {
				start = mid + 2;
			}
		}
		return index;
	}
}
