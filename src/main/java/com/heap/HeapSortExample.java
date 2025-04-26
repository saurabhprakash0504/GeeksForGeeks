package com.heap;

import java.util.Arrays;

public class HeapSortExample {

    public static void main(String[] args) {
        //int[] arr = {1, 7, 10, 5, 50, 4, 20, 100, 80};
        int[] arr = {10, 5, 50, 4, 20};
        //  createMaxHeap(arr);
        // swapValue(arr, 0, arr.length - 1);
        System.out.println("arr1 >> " + Arrays.toString(arr));
        //   int i = 0;
        sort(arr);
        System.out.println("final Array  >> " + Arrays.toString(arr));

    }

    static public void buildheap(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifys(arr, n, i);
    }

    static public void sort(int arr[]) {
        int n = arr.length;

        buildheap(arr, n);

        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifys(arr, i, 0);
        }
    }

    static void heapifys(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapifys(arr, n, largest);
        }
    }

    static void createMaxHeap(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            int parent = (i - 1) / 2;
            if (arr[parent] < arr[i]) {
                swapValue(arr, parent, i);
            }
        }
    }

 /*   static void heapify(int[] arr, int lastIndex) {
     //   for (int i = 0; i <= lastIndex; i++) {
            int left =  1;
            int right = 2;
            int max = arr[0];
            int maxIndex = 0;
            if(left <= lastIndex){
                if(max < arr[left]) {
                    max = arr[left];
                    maxIndex = left;
                }
            }
           if(right <= lastIndex){
               if(max < arr[right]) {
                   max = arr[right];
                   maxIndex = right;
               }
           }

           swapValue(arr, 0, maxIndex);

    //    }
    }*/

   /* static void heapify(int[] arr, int index, int nextFreeIndex) {
        int left = 2 *index +1;
        int right = 2*index+2;
        int smallestIndex = index;

        if (left < nextFreeIndex && arr[left] > arr[smallestIndex]) {
            smallestIndex = left;
        }

        if (right < nextFreeIndex && arr[right] > arr[smallestIndex]) {
            smallestIndex = right;

        }

        if (smallestIndex != index) {
            swapValue(arr, index, smallestIndex);
            heapify(arr, smallestIndex, nextFreeIndex);
        }
    }*/

    private static void swapValue(int[] arr, int parent, int i) {
        int temp = arr[i];
        arr[i] = arr[parent];
        arr[parent] = temp;
    }
}
