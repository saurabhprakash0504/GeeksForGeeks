package com.array;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        //int[] arr = {2, 1, 5, 4, 3, 0, 0};
        int[] arr = {3, 2, 1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void nextPermutation(int[] arr) {
        // code here
        find(arr);
    }

    static void find(int[] arr) {

        //find the low point
        //find the smallest number
        //swap
        //sort the rest


        //Finding Low point
        int ind = findLowPoint(arr);
        if (ind == -1) {
            int s = 0;
            int e = arr.length - 1;
            while (s <= e) {

                swap(arr, s, e);
                s++;
                e--;
            }
            return;
        }

        //   Finding Smallest element index

        int smallestEleInd = findSmallestElementIndex(arr, ind);

        // swapping

        swap(arr, ind, smallestEleInd);

        //soring


        int s = ind + 1;
        int e = arr.length - 1;
        while (s <= e) {

            swap(arr, s, e);
            s++;
            e--;
        }

        //  System.out.println("final  >> "+ Arrays.toString(arr));
    }

    static int findLowPoint(int[] arr) {

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                return i;
            }
        }

        return -1;
    }


    static int findSmallestElementIndex(int[] arr, int ind) {

        int smallestValue = Integer.MAX_VALUE;
        int smallInd = arr.length - 1;

        for (int i = arr.length - 1; i > ind; i--) {
            if (arr[i] > arr[ind] && arr[i] < smallestValue) {
                smallInd = i;
                smallestValue = arr[smallInd];
            }
        }

        return smallInd;
    }

    static void swap(int[] arr, int ind, int smallestEleInd) {

        int temp = arr[ind];
        arr[ind] = arr[smallestEleInd];
        arr[smallestEleInd] = temp;
    }
}
