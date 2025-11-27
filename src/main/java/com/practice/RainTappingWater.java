package com.practice;

public class RainTappingWater {

    public static void main(String[] args) {
       // int[] arr ={3, 0, 1, 0, 4, 0, 2};
       // int[] arr = {3, 0, 2, 0, 4};
        int[] arr = {1, 2, 3, 4};
        System.out.println(find(arr)); ;
    }

    static int find(int[] arr){
        int[] leftBig = new int[arr.length];
        int[] rightBig = new int[arr.length];

        leftBig[0] = arr[0];
        for(int i=1;i< arr.length;i++){
            if(arr[i] > leftBig[i-1]){
                leftBig[i] = arr[i];
            }else {
                leftBig[i] = leftBig[i-1];
            }
        }

        rightBig[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2;i>=0 ;i--){
            if(arr[i] > rightBig[i+1]){
                rightBig[i] = arr[i];
            }else {
                rightBig[i] = rightBig[i+1];
            }
        }

        int val = 0;
        for(int i=0;i< arr.length;i++){
            int min = Integer.min(leftBig[i],rightBig[i] );
            int diff = min - arr[i];
            val = val +diff;
        }
        return val;
    }
}
