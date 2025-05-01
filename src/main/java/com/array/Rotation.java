package com.array;

import java.util.Arrays;

public class Rotation {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        rotateArr(arr,2);

        System.out.println(Arrays.toString(arr));
    }

    static void rotateArr(int arr[], int d) {
        // add your code here
        // swap(arr,0,d-1);
        int start=0;
        int end = d-1;
        while(start<end){
            // System.out.println("start "+arr[start] +" " );
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        start = d;
        end = arr.length-1;
        while(start<end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        //  swap(arr,d,arr.length-1);

        //swap(arr,0,arr.length-1);

        start=0;
        end= arr.length-1;
        while(start<end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    static void swap(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
