package com.dynamicProgramming;

import java.util.Arrays;

public class SticklerThief {

    public static void main(String[] args) {
        int arr[] = {6, 5, 5, 7, 4};
        System.out.println(findMaxSum(arr));
    }

    public static int findMaxSum(int arr[]) {
        // code here
        int len = arr.length;
        //return find(arr, len, 0);

        int[] dp = new int[len + 1];
        Arrays.fill(dp, -1);

        //   return findMem(arr, len, 0, dp);

        //  return findTab(arr,len);
        return findTabSO(arr, len);
    }

    static int find(int[] arr, int len, int ind) {
        if (ind >= len) {
            return 0;
        }

        int inc = arr[ind] + find(arr, len, ind + 2);
        int exc = find(arr, len, ind + 1);

        return Integer.max(inc, exc);
    }

    static int findTab(int[] arr, int len) {

        int[] dp = new int[len + 2];
        Arrays.fill(dp, 0);

        for (int ind = len - 1; ind >= 0; ind--) {


            int inc = arr[ind] + dp[ind + 2];
            int exc = dp[ind + 1];

            dp[ind] = Integer.max(inc, exc);
        }

        return dp[0];
    }


    static int findTabSO(int[] arr, int len) {

        //  int[] dp = new int[len+2];
        // Arrays.fill(dp, 0);
        int prev2 = 0;
        int prev1 = 0;

        for (int ind = len - 1; ind >= 0; ind--) {


            int inc = arr[ind] + prev2;
            int exc = prev1;

            int temp = Integer.max(inc, exc);
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }


    static int findMem(int[] arr, int len, int ind, int[] dp) {
        if (ind >= len) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int inc = arr[ind] + findMem(arr, len, ind + 2, dp);
        int exc = findMem(arr, len, ind + 1, dp);

        return dp[ind] = Integer.max(inc, exc);
    }
}
