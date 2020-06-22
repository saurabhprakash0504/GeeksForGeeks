package com.sorting;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] arr= {319,212,6,8,100,50};
		System.out.println("input array >> "+Arrays.toString(arr));
		method1(arr);
		System.out.println("final array >> "+Arrays.toString(arr));
	}

	static void method1(int[] arr) {
		int biggest =findBiggestNumber(arr);
		int digit = countDigit(biggest);
		int k=1;
		for(int i=1;i<=digit;i=i+1) {
			countSort(arr,k);
			k=k*10;
		}
	}

	static void countSort(int[] arr, int k) {
		int[] count = new int[10];
		for (int i = 0; i < arr.length; i++) {
			count[(arr[i]/k)%10]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i - 1];
		}

		int[] temp=new int[arr.length];
		for(int i =temp.length-1;i>=0;i--) {
			temp[count[(arr[i]/k)%10]-1]=arr[i];
			count[(arr[i]/k)%10]--;
		}

		for(int i =0;i<temp.length;i++) {
			arr[i]=temp[i];
		}
		//System.out.println(Arrays.toString(arr));
	}

	private static int countDigit(int biggest) {
		int count=0;
		while(biggest>0) {
			count++;
			biggest=biggest/10;
		}
		return count;
	}

	private static int findBiggestNumber(int[] arr) {
		int max= Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			max=max>arr[i]?max:arr[i];
		}
		return max;
	}
}
