package com.sorting;

public class QuickSortLoveBabbar {

    public static void main(String[] args) {

        int[] arr= {10, 7, 8, 9, 1, 5};
        QuickSortLoveBabbar qs= new QuickSortLoveBabbar();
        qs.quickSort(arr, 0, arr.length-1);
        for(int num: arr){
            System.out.print(num + " ");
        }

    }

    public void quickSort(int[] arr, int s, int e) {
        if(s >=e){
            return ;
        }
        int newPivotIndex = partition(arr, s, e);

        quickSort(arr, s, newPivotIndex-1);
        quickSort(arr, newPivotIndex+1, e);
    }

    private int partition(int[] arr, int s, int e) {
        int pivot = arr[s];
        int noOfSmallerElement =0;
        for(int i=s+1;i<=e;i++){
            if(arr[i]<= pivot){
                noOfSmallerElement++;
            }
        }

        int newPivotIndex = s + noOfSmallerElement;

        swap(arr, s, newPivotIndex);

        int i=s;
        int j= e;
        while(i <newPivotIndex && j > newPivotIndex){

            while(arr[i] <= arr[newPivotIndex]){
                i++;
            }

            while(arr[j] > arr[newPivotIndex]){
                j--;
            }

            if(i <newPivotIndex && j > newPivotIndex)
                swap(arr, i, j);
            i++;
            j--;

        }

        return newPivotIndex;

    }

    void swap(int[] arr, int s, int newPivotIndex){
        int temp= arr[s];
        arr[s] = arr[newPivotIndex];
        arr[newPivotIndex]= temp;
    }
}
