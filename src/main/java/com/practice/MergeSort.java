package com.practice;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int arr[] = {5,4,1,2,1,7,3};
        MergeSort ms = new MergeSort();
        ms.mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    void mergeSort(int arr[], int l, int r) {
        // code here
        if(l >= r){
            return;
        }

        int m = l+(r-l)/2;

        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);

        conquerAndMerge(arr, l, r);

    }

    void conquerAndMerge (int[] arr, int s, int e){
        int m = s+(e-s)/2;

        int len1 = m-s+1;
        int len2 = e - m;

        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        //copy
        int j=0;
        for(int i=s;i <=m;i++){
            arr1[j]= arr[i];
            j++;
        }


        int k=0;
        for(int i=m+1;i <=e;i++){
            arr2[k]= arr[i];
            k++;
        }

        j=0; k=0;
        while(j < len1 && k < len2){
            if(arr1[j] < arr2[k]){
                arr[s]= arr1[j];
                j++;
                s++;
            }else{
                arr[s] = arr2[k];
                k++;
                s++;
            }
        }

        while(j<len1){
            arr[s]= arr1[j];
            j++;
            s++;
        }

        while(k<len2){
            arr[s]= arr2[k];
            k++;
            s++;
        }
    }
}
