package com.dynamicProgramming;

import java.util.Arrays;

public class StairCaseProbOrderDoesNotMatter {

    public static void main(String[] args) {

        StairCaseProbOrderDoesNotMatter obj = new StairCaseProbOrderDoesNotMatter();
        int n = 4;
        System.out.println(obj.countWays(n));

    }

    Long countWays(int n) {
        // your code here
        int[] arr = {1,2};

        // return find(n, arr, 0);

        Long[][] dp = new Long[n+1][2];
        for(int i=0;i< n+1;i++){
            Arrays.fill(dp[i], -1L);
        }

        return findMem(n, arr, 0, dp);

    }

    Long find(int n, int[] arr, int ind){
        if(n ==0){
            return 1L;
        }

        if(n < 0){
            return 0L;
        }

        if(ind >= arr.length){
            return 0L;
        }

        Long inc = find(n-arr[ind], arr, ind);
        Long exc = find(n, arr, ind+1);

        return inc + exc;
    }


    Long findMem(int n, int[] arr, int ind, Long[][] dp){
        if(n ==0){
            return 1L;
        }

        if(n < 0){
            return 0L;
        }

        if(ind >= arr.length){
            return 0L;
        }

        if(dp[n][ind] !=-1){
            return dp[n][ind];
        }

        Long inc = findMem(n-arr[ind], arr, ind, dp);
        Long exc = findMem(n, arr, ind+1, dp);

        return dp[n][ind] = inc + exc;
    }
}
