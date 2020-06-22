package com.sorting;

import java.util.Arrays;

class Sort012
{
    // Function to segregate 0s, 1s and 2s
    // A[]: input array
    // n: size of array
    public static void segragate012(int arr[], int n){
        // your code here
        int start=-1;
        int mid=0;
        int end=n;
        while(mid<end){
            if(arr[mid]==0){
             start = start+1;
             swap(arr,mid,start);
             mid = mid+1;
            }else if(arr[mid]==1){
                mid=mid+1;
            }else{
                end= end -1;
                swap(arr,mid,end);
            }
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
		int[] arr= {0, 2, 1, 2, 0};
		segragate012(arr,arr.length);
		System.out.println("arr >> "+Arrays.toString(arr));

	}
}