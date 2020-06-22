package com.sorting;

import java.util.Arrays;

public class MergeSortDemo {
	public static void main(String[] args) {
		int[] arr = {4 ,1, 3, 9, 7};
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int m=l+(r-l)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr,l,m,r);
		}
	}

	static void merge(int arr[], int l, int m, int r)
	    {
	         int[] arr1=new int[m-l+1];
	         int[] arr2=new int[r-m];
	         for(int i=l;i<=m;i++){
	             arr1[i-l]=arr[i];
	         }
	         for(int j=m+1;j<=r;j++){
	             arr2[j-(m+1)]=arr[j];
	         }

	         int i=0;
	         int j=0;
	         while(i<arr1.length && j<arr2.length){
	             if(arr1[i]<arr2[j]){
	                 arr[l]=arr1[i];
	                 i++;
	             }else{
	                 arr[l]=arr2[j];
	                 j++;
	             }
	             l++;
	         }
	         if(i==(arr1.length)){
	             while(j<(arr2.length)){
	                 arr[l]=arr2[j];
	                 j++;
	                 l++;
	             }
	         }else{
	             while(i<(arr1.length)){
	                 arr[l]=arr1[i];
	                 i++;
	                 l++;
	             }
	         }


	    }
	}

