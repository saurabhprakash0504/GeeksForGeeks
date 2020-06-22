package com.hash;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RelativeSorting {
	public static void main(String[] args) {
		int[] arr1= {2 ,1 ,2 ,5 ,7 ,1, 9, 3, 6 ,8 ,8};
		int[] arr2= {2 ,1 ,8 ,3};
		relativeSorting(arr1, arr2);
	}

	static void relativeSorting(int[] arr1, int[] arr2) {
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		for(int i=0;i<arr1.length;i++) {
			if(h.containsKey(arr1[i])) {
				h.put(arr1[i], h.get(arr1[i])+1);
			}else {
				h.put(arr1[i], 1);
			}
		}
		int count=0;
		for(int i=0;i<arr2.length;i++) {
			int temp=h.get(arr2[i]);
			while(temp>0) {
				arr1[count]=arr2[i];
				count++;
				temp--;
			}
			h.remove(arr2[i]);
		}

		List l =Arrays.asList(h.keySet().toArray());

		Collections.sort(l);

		for(int i=0;i<l.size();i++) {
			int temp=h.get(l.get(i));
			while(temp>0) {
				arr1[count]=(int) l.get(i);
				count++;
				temp--;

			}
			h.remove(arr2[i]);
		}

		for(int i:arr1) {
			System.out.print(i+" ");
		}

	}
}
