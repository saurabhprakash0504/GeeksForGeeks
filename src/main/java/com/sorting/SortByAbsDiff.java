package com.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByAbsDiff {
	public static void main(String[] args) {
		int[] arr= {10,5,3,9,2};
		int num=7;
		absDiff(arr, num);
	}

	static void absDiff(int[] arr, int num) {
		List<Points> al = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			Points p = new Points();
			p.i=arr[i];
			p.diff= Math.abs(arr[i]-num);
			al.add(p);
		}
		Collections.sort(al, new Points());

		for(int i =0;i<al.size();i++) {
			System.out.println(al.get(i).i);
		}

	}

}

class Points implements Comparator<Points> {
	int i;
	int diff;

	@Override
	public int compare(Points o1, Points o2) {
		if (o1.diff > o2.diff) {
			return 1;
		} else if (o1.diff < o2.diff) {
			return -1;
		} else {
			return 0;
		}
	}

}
