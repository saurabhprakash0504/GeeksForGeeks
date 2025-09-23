package com.dynamicProgramming;

import java.util.Arrays;

public class ReachAGivenScore {

    public static void main(String[] args) {

        ReachAGivenScore obj = new ReachAGivenScore();
        int n = 13;
        System.out.println(obj.count(n));

    }

    int count(int n) {
        // Your code here
        // return findPermutation(n);

        int[] arr = {3, 5, 10};
        // return findComb(n, arr, 0);

    /*   int[][] dp = new int[n+1][3];
       for(int i=0;i< n+1;i++){
           Arrays.fill(dp[i], -1);
       }

       return findCombMem(n, arr, 0, dp);*/

        //return findCombTab(n, arr);

        //return findCombTab2(n, arr);

        return findCombTab2SO(n, arr);
    }

    int findPermutation(int n) {

        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        return findPermutation(n - 3) + findPermutation(n - 5) + findPermutation(n - 10);

    }


    int findComb(int n, int[] arr, int ind) {

        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (ind >= arr.length) {
            return 0;
        }

        int inc = findComb(n - arr[ind], arr, ind);
        int exc = findComb(n, arr, ind + 1);

        return inc + exc;

    }


    int findCombMem(int n, int[] arr, int ind, int[][] dp) {

        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (ind >= arr.length) {
            return 0;
        }

        if (dp[n][ind] != -1) {
            return dp[n][ind];
        }

        int inc = findCombMem(n - arr[ind], arr, ind, dp);
        int exc = findCombMem(n, arr, ind + 1, dp);

        return dp[n][ind] = inc + exc;

    }


    int findCombTab(int i, int[] arr) {


        int[][] dp = new int[i + 1][arr.length + 1];
        for (int j = 0; j < arr.length + 1; j++) {
            dp[0][j] = 1;
        }


        for (int n = 1; n <= i; n++) {
            for (int ind = arr.length - 1; ind >= 0; ind--) {
                int inc = 0;
                int exc = 0;
                if (n - arr[ind] >= 0)
                    inc = dp[n - arr[ind]][ind];

                exc = dp[n][ind + 1];

                dp[n][ind] = inc + exc;
            }
        }

        return dp[i][0];
    }


    int findCombTab2(int i, int[] arr) {


        int[][] dp = new int[arr.length + 1][i + 1];
        for (int j = 0; j < arr.length + 1; j++) {
            dp[j][0] = 1;
        }

        for (int ind = arr.length - 1; ind >= 0; ind--) {
            for (int n = 1; n <= i; n++) {

                int inc = 0;
                int exc = 0;
                if (n - arr[ind] >= 0)
                    inc = dp[ind][n - arr[ind]];

                exc = dp[ind + 1][n];

                dp[ind][n] = inc + exc;
            }
        }

        return dp[0][i];
    }


    int findCombTab2SO(int i, int[] arr) {

        int[] next = new int[i + 1];

        int[] curr = new int[i + 1];

        Arrays.fill(curr, 1);

        for (int ind = arr.length - 1; ind >= 0; ind--) {
            for (int n = 1; n <= i; n++) {

                int inc = 0;
                int exc = 0;
                if (n - arr[ind] >= 0)
                    inc = curr[n - arr[ind]];

                exc = next[n];

                curr[n] = inc + exc;
            }
            next = curr.clone();
        }

        return next[i];
    }

}
