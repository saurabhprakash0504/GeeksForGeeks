package com.hash;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsSubSeq {
	public static void main(String[] args) {
		int[] arr = { 86, 177, 115, 193, 135, 186, 92, 49, 21, 162, 27, 90, 59, 163, 126, 140, 26, 172, 136, 11, 168,
				167, 29, 182, 130, 62, 123, 67, 129, 2, 22, 58, 69, 56, 42, 173, 119, 184, 137, 198, 124, 170, 13, 91,
				180, 156, 73, 196, 81, 105, 125, 84, 127, 46, 113, 57, 95, 145, 14, 34, 164, 43, 150, 87, 8, 76, 178,
				188, 3, 51, 154, 199, 132, 60, 139, 12, 94, 195, 1, 97, 102, 117, 52, 101 };
		System.out.println(findLongestConseqSubseq(arr, arr.length));
	}

	static int findLongestConseqSubseq(int arr1[], int n) {
		HashSet<Integer> h = new HashSet<Integer>();
		for (int i : arr1) {
			h.add(i);
		}
		int[] arr = new int[h.size()];
		int count = 0;
		for (int i : h) {
			arr[count] = i;
			count++;
		}
		Arrays.sort(arr);
		int curr = 1;
		int max = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1] + 1) {
				curr++;
			} else {
				curr = 1;
			}
			if (max < curr) {
				max = curr;
			}
		}
		return max;
	}
}
