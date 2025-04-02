package com.array;

import java.util.Arrays;

public class MaxCircularSubArray {

    public static void main(String[] args) {

      //  int[] arr = {5, -2, 3, 4};

        //int[] arr = { 2, 3, -4};
        //int[] arr = {8, -4, 3, -5, 4};

        int[] arr = {-5, -3};

        System.out.println(maxCircularSubArray(arr));
        System.out.println(maxCircularSubArray2(arr));
    }

    static int maxCircularSubArray(int[] arr){

        int maxValue = Integer.MIN_VALUE;

        for(int i=0;i< arr.length;i++){

            int currSum = 0;
            for (int j=0;j<arr.length;j++){

                int index = (i+j)% arr.length;

                currSum = currSum + arr[index];

                maxValue = Integer.max(currSum, maxValue);

            }
        }
        return maxValue;
    }


    static int maxCircularSubArray2(int[] arr){

        int maxInNormalSubArray = maxSubarraySum(arr);

        if(maxInNormalSubArray < 0){
            return maxInNormalSubArray;
        }

        int maxInCircullar = totalSum(arr) - minSubarraySum(arr);

        return Integer.max(maxInNormalSubArray, maxInCircullar);

    }

    static int maxSubarraySum(int[] arr) {

        int maxSum = arr[0];
        int prevMax = arr[0];

        for(int i=1;i<arr.length;i++){

            int currMax = prevMax + arr[i];
            prevMax= Integer.max(currMax, arr[i]);
            maxSum= Integer.max(prevMax, maxSum);

        }
        return maxSum;

    }

    static int minSubarraySum(int[] arr) {

        int maxSum = arr[0];
        int prevMax = arr[0];

        for(int i=1;i<arr.length;i++){
            int currMax = prevMax + arr[i];
            prevMax= Integer.min(currMax, arr[i]);
            maxSum= Integer.min(prevMax, maxSum);
        }
        return maxSum;

    }

    static int totalSum(int[] arr){

        int totalSum=0;

        totalSum = Arrays.stream(arr).sum();

        return totalSum;
    }


}
