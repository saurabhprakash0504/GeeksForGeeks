package com.sorting;

public class InversionCount {

	static long count = 0;

	public static void main(String[] args) {
		long[] arr = {10, 10, 10};
		System.out.println(inversionCount(arr, arr.length));
	}

	static long inversionCount(long arr[], long n) {
		// add your code here
		mergeSort(arr, 0, n - 1);
		return count;

	}

	static void mergeSort(long[] arr, long start, long end) {
		if (end > start) {
			long mid = start + (end - start) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
			// System.out.println(Arrays.toString(arr));
		}
	}

	private static void merge(long[] arr, long start, long mid, long end) {
		long firstLength = mid - start + 1;
		long secondLength = end - (mid + 1) + 1;
		long[] first = new long[(int) firstLength];
		long[] second = new long[(int) secondLength];
		long i = 0, j = 0;
		long firstStart = start;

		// copying first
		while (i <= firstLength - 1) {
			first[(int) i] = arr[(int) firstStart];
			firstStart++;
			i++;
		}
		long secondStart = mid + 1;
		// copying second
		while (j <= secondLength - 1) {
			second[(int) j] = arr[(int) secondStart];
			secondStart++;
			j++;
		}

		i = 0;
		j = 0;

		while (i != firstLength && j != secondLength) {
			if (first[(int) i] <= second[(int) j]) {
				arr[(int) start] = first[(int) i];
				i++;
			} else {
				arr[(int) start] = second[(int) j];
				count=count+(first.length-i);
				j++;
			}
			start++;
		}

		// copying rest of the element
		while (i < firstLength) {
			arr[(int) start] = first[(int) i];
			//count++;
			start++;
			i++;
		}

		// copying rest of the element
		while (j < secondLength) {
			arr[(int) start] = second[(int) j];
			j++;
			start++;
		}
	}

}
