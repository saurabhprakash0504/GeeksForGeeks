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
        int n = arr.length - 1;
        int small = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                small = i;
                break;
            }
        }

        if (small == 0) {
            int start = 0;
            int end = n;
            while (start < end) {
                swap(arr, start, end);
                start++;
                end--;
            }
            return;
        }

        int smallest = Integer.MAX_VALUE;
        int index = n;
        for (int j = n; j > small; j--) {
            if (arr[j] > arr[small] && arr[j] < smallest) {
                index = j;
                smallest = arr[j];
            }
        }

        swap(arr, index, small);

        //END

      /*  for (int i = N - 1; i > ind; i--) {
            if (arr[i] > arr[ind]) {
                swap(i, ind, arr);
                ind++;
                break;
            }
        }*/

        //END arr[

        int start = small + 1;
        int end = n;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }

    }

    static void swap(int[] arr, int smallest, int small) {
        int temp = arr[smallest];
        arr[smallest] = arr[small];
        arr[small] = temp;
    }
}
