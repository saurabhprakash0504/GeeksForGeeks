package com.searching;

public class CountOccuranceMorethanNByK {

	public static void main(String[] args) {
		int[] arr = {3, 1, 2 ,2 ,1 ,2 ,3, 3};
		int k=4;
		System.out.println(countOccurence(arr, arr.length, k));
	}

	public static int countOccurence(int[] arr, int n, int k) {
        // your code here,return the answer
        int value=n/k;
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxValue){
                maxValue=arr[i];
            }
        }
        System.out.println("maxValue >>"+maxValue);
        int[] temp=new int[maxValue+1];
        for(int i=0;i<arr.length;i++){
            temp[arr[i]]=temp[arr[i]]+1;
        }
        int count=0;
        for(int i=0;i<temp.length;i++){
           if(temp[i]>value){
               count++;
           }
        }
        return count;
    }

}
