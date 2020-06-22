package com.sorting;

import java.util.Arrays;

public class MergeThreeSortedArray {
	public static void main(String[] args) {
		int[] arr1= {1 ,2 ,3 ,4};
		int[] arr2= {1, 2, 3, 4, 5};
		int[] arr3= {1, 2, 3, 4, 5, 6};
		merge(arr1,arr2,arr3);
	}

	static void merge(int[] arr1, int[] arr2, int[] arr3) {
		int arr1Size=arr1.length;
		int arr2Size=arr2.length;
		int arr3Size=arr3.length;

		int[] temp1=new int[arr1Size+arr2Size];

		int i=0,j=0,k=0;

		while(i<arr1Size && j<arr2Size) {
			if(arr1[i]<arr2[j]) {
				temp1[k]=arr1[i];
				i++;
			}else {
				temp1[k]=arr2[j];
				j++;
			}
			k++;
		}

		if(i==arr1Size) {
			while(j<arr2Size) {
				temp1[k]=arr2[j];
				j++;
				k++;
			}
		}

		if(j==arr2Size) {
			while(i<arr1Size) {
				temp1[k]=arr1[i];
				i++;
				k++;
			}
		}

		// second array

		int[] temp2=new int[temp1.length+arr3Size];

		int ii=0,jj=0,kk=0;

		while(ii<temp1.length && jj<arr3Size) {
			if(temp1[ii]<arr3[jj]) {
				temp2[kk]=temp1[ii];
				ii++;
			}else {
				temp2[kk]=arr3[jj];
				jj++;
			}
			kk++;
		}

		if(ii==temp1.length) {
			while(jj<arr3Size) {
				temp2[kk]=arr3[jj];
				jj++;
				kk++;
			}
		}

		if(jj==arr3Size) {
			while(ii<temp1.length) {
				temp2[kk]=temp1[ii];
				ii++;
				kk++;
			}
		}
		System.out.println(Arrays.toString(temp2));
	}
}
