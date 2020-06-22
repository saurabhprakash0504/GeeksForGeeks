package com.hash;

import java.util.HashMap;

class countsubArray {
	static int countSubarrWithEqualZeroAndOne(int a[], int n) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int sum = 0;
		int flag = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				a[i] = -1;
			}
			sum = sum + a[i];
			if (sum == 0) {
				flag++;
			}
			if (hm.containsKey(sum))
				flag += hm.get(sum);
			if (!hm.containsKey(sum))
				hm.put(sum, 1);
			else {
				int x = hm.get(sum);
				hm.put(sum, x + 1);
			}
		}
		System.out.println(hm);
		return flag;
	}

	public static void main(String[] args) {
		int[] arr= {1, 0, 0 ,1 ,0 ,1 ,1};
		System.out.println(countSubarrWithEqualZeroAndOne(arr, arr.length));;
	}

}