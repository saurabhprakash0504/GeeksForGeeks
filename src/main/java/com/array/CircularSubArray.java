package com.array;

public class CircularSubArray {

    public static void main(String[] args) {
        //int[] arr = {-1, 40, -14, 7, 6, 5, -4, -1};
        //  int[]  arr = {-7, 32, -11, 21, 18 ,35 ,-26 ,-17 ,35, -12 ,-38 ,-33, 32 ,16, 44, 11, -40, -21 ,2 ,27, -35 ,21 ,-37 ,-12, 1};
        int[] arr = {-2, -3, -4};
        System.out.println(circularSubarraySum(arr));
    }

    public static int circularSubarraySum(int arr[]) {

        int totalSum = 0;
        boolean allNegative = true;
        for (int i = 0; i < arr.length; i++) {
            totalSum = totalSum + arr[i];
            if (arr[i] > 0) {
                allNegative = false;
            }
        }

        int val = findMaxSubArray(arr);
        if (allNegative) {
            return val;
        }
        int n = findMinSubArray(arr);


        if (n < 0) {
            totalSum = totalSum - n;
        }

        return Integer.max(totalSum, val);


    }

    static int findMinSubArray(int[] arr) {
        int min = Integer.MAX_VALUE;
        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr = Integer.min(arr[i] + curr, arr[i]);
            min = Integer.min(curr, min);
        }
        return min;
    }

    static int findMaxSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr = Integer.max(arr[i] + curr, arr[i]);
            max = Integer.max(curr, max);
        }
        return max;
    }
}
