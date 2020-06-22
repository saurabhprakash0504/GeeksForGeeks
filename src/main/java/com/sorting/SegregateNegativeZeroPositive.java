package com.sorting;

import java.util.Arrays;

public class SegregateNegativeZeroPositive {
	public static void main(String[] args) {
		int arr[]= {1,-1,-2,0,4,5,0};
		//method1(arr);
		method2(arr);
	}

	static void method1(int[] arr) {
		int[] temp=new int[arr.length];
		int pos=arr.length-1;
		int neg=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				temp[pos]=arr[i];
				pos--;
			}if(arr[i]<0) {
				temp[neg]=arr[i];
				neg++;
			}
		}
		System.out.println(Arrays.toString(temp));
	}

	static void method2(int[] arr) {
		System.out.println(Arrays.toString(arr));
		int beg=0;
		int mid=0;
		int end=arr.length-1;
		while(mid<=end) {
			if(arr[mid]<0) {
				swap(arr,mid,beg);
				beg++;
				mid++;
			}else if(arr[mid]==0) {
				mid++;
			}else {
				swap(arr,mid,end);
				end--;
			}
		}
		System.out.println("Arrays "+Arrays.toString(arr));
	}

	private static void swap(int[] arr, int mid, int beg) {
		int temp = arr[mid];
		arr[mid] = arr[beg];
		arr[beg] = temp;

	}
}
