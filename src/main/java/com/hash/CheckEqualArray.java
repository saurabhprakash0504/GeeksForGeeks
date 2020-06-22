package com.hash;

import java.util.HashMap;

public class CheckEqualArray {
	public static void main(String[] args) {
		//int[] a = { 1, 1, 3, 4, 5 };
		//int[] b = { 5, 4, 3, 3, 1 };
		int[] a= {1 ,2 ,5};
		int[] b= {2 ,4 ,15};
		System.out.println(check(a, b));
	}

	static boolean check(int[] a, int[] b) {
		boolean flag = true;
		HashMap<Integer, Integer> s = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			// a[i] = sc.nextInt();
			if (s.containsKey(a[i]))
				s.put(a[i], s.get(a[i]) + 1);
			else
				s.put(a[i], 1);
		}
		System.out.print(s);
		for (int i = 0; i < b.length; i++) {
			// b[i] = sc.nextInt();
			if (s.containsKey(b[i])) {
				s.put(b[i], s.get(b[i]) - 1);
				if (s.get(b[i]) == 0) {
					s.remove(b[i]);
				}
			} else {
				flag = false;
				break;
			}

		}

		if (flag) {
			System.out.println("1");

		} else {
			System.out.println("0");
			// flag= true;
		}
		return flag;

	}
}
