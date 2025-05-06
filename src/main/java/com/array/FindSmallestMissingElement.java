package com.array;

import java.util.Arrays;

public class FindSmallestMissingElement {

    public static void main(String[] args) {
        //int[] arr = {1, 3, 6, -4, 2,4};
        // int[] arr= {0, -10, 1,3,-20};
        int[] arr = {12, -7, 12, 10, -6, 4, -18, 12, 0, 10, 17, 0, 1, 2, 2, 9, -7, 16};
        System.out.println(findSmallestElement(arr));
    }

    static int findSmallestElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int absIndex = Math.abs(arr[i]);
            if (absIndex > 0 && absIndex < arr.length + 1) {
                int index = absIndex;
                if (arr[index - 1] == 0)
                    arr[index - 1] = -(arr.length + 1);
                if (arr[index - 1] > 0)
                    arr[index - 1] = -arr[index - 1];

            }
        }

        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i]);
            //  int index = val;

            if (val > 0 && val < arr.length + 1) {
                int index = val - 1;
                if (arr[index] == 0) {
                    arr[index] = -(arr.length + 1);
                } else if (arr[index] > 0){
                    arr[index] = -arr[index];
                }
            }
        }


        System.out.println(Arrays.toString(arr));


        int smallest = arr.length + 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                return i + 1;
            }
        }
        return smallest;

    }
}
