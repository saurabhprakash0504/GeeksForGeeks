package com.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxInAllSubArrayOfSizeK {

	public static void main(String[] args) {
		int[] arr = { 100, 50, 40, 10, 100 };
		int k = 3;
		System.out.println(max_of_subarrays(arr, arr.length, k));
	}

	static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        // Your code here
        ArrayList<Integer> al = new ArrayList<>();
		Deque<Integer> d = new LinkedList<Integer>();
		d.offer(0);
		int i = 1;
		while (i < k) {
			if (arr[i] < arr[d.peek()]) {
				d.offerLast(i);
			} else {
				d.offerFirst(i);
			}
			i++;
		}
		al.add(arr[d.peek()]);
		//System.out.println(arr[d.peek()]);
		for (i = k; i < arr.length; i++) {

			if (arr[i] > arr[d.peekFirst()]) {
				d.clear();
				d.offerFirst(i);
			} else {

				while((!d.isEmpty()) && (d.peekFirst() <= i-k || arr[d.peekFirst()]<=arr[i])) {
					d.pollFirst();
				}
				if(d.isEmpty() || arr[d.peekFirst()]<=arr[i]){
				    d.offerFirst(i);
				}
			    else
					d.offerLast(i);
			}
			//System.out.println(arr[d.peek()]);
			al.add(arr[d.peek()]);
		}
	return al;
    }

}
