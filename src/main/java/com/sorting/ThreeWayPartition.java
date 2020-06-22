package com.sorting;

import java.util.ArrayList;

public class ThreeWayPartition {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(3);
		al.add(4);

		al.add(2);
		al.add(3);
		al.add(2);
		al.add(1);

		threeWayPartition(al,1,2);
		System.out.println(al);

	}

	public static ArrayList<Integer> threeWayPartition(ArrayList<Integer> q , int a, int b)
	{
		int start = -1;
		int mid = 0;
		int end = q.size();

		while (mid < end) {
			if (q.get(mid) < a) {
				start = start + 1;
				swap(q, start, mid);
				mid = mid + 1;
			} else if (q.get(mid) >= a && q.get(mid) <= b ) {
				mid++;
			} else {
				end = end - 1;
				swap(q, end, mid);
			}
		}

		return q;
	}

	static void swap(ArrayList<Integer> q, int i, int j) {
		int temp = q.get(i);
		q.set(i, q.get(j));
		q.set(j, temp);
	}
}
