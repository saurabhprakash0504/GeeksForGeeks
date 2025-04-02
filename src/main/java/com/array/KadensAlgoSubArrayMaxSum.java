package com.array;

public class KadensAlgoSubArrayMaxSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
         //int[] arr = {-6, -8, -3};
        // int[] arr = {6, 8, 3};
        System.out.println(maxSubarraySum(arr));
        System.out.println(maxSubarraySum2(arr));
    }

    static int maxSubarraySum(int[] arr) {
        int MAX_SUM = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currSum = arr[i];
            // MAX_SUM = Integer.max(currSum, MAX_SUM);
            for (int j = i + 1; j < arr.length; j++) {
                currSum = currSum + arr[j];
                //  MAX_SUM = Integer.max(currSum, MAX_SUM);
            }
            MAX_SUM = Integer.max(currSum, MAX_SUM);

        }
        return MAX_SUM;
    }

    static int maxSubarraySum2(int[] arr) {
        // Your code hjjjere

        int maxSum = arr[0];
        int prevMax = arr[0];

        for(int i=1;i<arr.length;i++){

            int currMax = prevMax + arr[i];
            prevMax= Integer.max(currMax, arr[i]);
            maxSum= Integer.max(prevMax, maxSum);

        }
        return maxSum;

    }
}
