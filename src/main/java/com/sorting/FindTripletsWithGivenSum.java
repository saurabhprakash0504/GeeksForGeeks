package com.sorting;

import java.util.Arrays;

public class FindTripletsWithGivenSum {

	public static void main(String[] args) {
		int[] arr= {174, 430, 405, 706, 627, 813, 376, 94, 566, 37, 737, 142, 815, 995, 257, 653, 937, 839, 483, 356, 16, 132, 231 ,842, 626, 12, 638};
		System.out.println(find3Numbers(arr, arr.length, 1107));
	}


	  public static int find3Numbers(int arr[], int n, int x) {
	       int count=0;
	       Arrays.sort(arr);
	       for(int i=0;i<n;i++){
	           int big=arr[i];
	           int diff=x-big;
	           int start=i+1;
	           int end=n-1;
	           while(start<end){
	               int sum=arr[start]+arr[end];
	               if(sum == diff){
	            	   System.out.println();
	                   count++;
	                   start++;
	                   end--;
	               }
	               else if(sum<diff){
	                   start=start+1;
	               }else {
	                   end= end-1;
	               }
	           }
	       }
	       return count;
	    }

}
