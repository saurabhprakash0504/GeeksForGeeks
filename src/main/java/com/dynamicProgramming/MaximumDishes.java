package com.dynamicProgramming;

import java.util.Arrays;

public class MaximumDishes {

    public static void main(String[] args) {
        int[] sat = {-1,-8,0,5,-9};
        MaximumDishes maximumDishes = new MaximumDishes();
        maximumDishes.maxSatisfaction(sat);
    }

    public int maxSatisfaction(int[] sat) {
        Arrays.sort(sat);
        int len = sat.length;
        // return find(sat, 0, len,1, 0);

        int[][] dp = new int[len+1][len+1];
        for(int i=0;i<=len;i++){
            Arrays.fill(dp[i], -1);
        }
        return findMem(sat, 0, len,1, dp);
        //  return dp[len][len];
    }

    int find(int[] sat, int ind, int len, int time, int sum){
        if(ind == len){
            return sum;
        }

        int inc = find(sat, ind+1, len, time+1, sum+(sat[ind]*(time)) );
        int exc = find(sat, ind+1, len, time, sum);

        return Integer.max(inc, exc);


    }


    int findMem(int[] sat, int ind, int len, int time, int[][] dp){
        if(ind == len){
            return 0;
        }

        if(dp[ind][time] != -1){
            return dp[ind][time];
        }

        int inc = sat[ind]*time +findMem(sat, ind+1, len, time+1, dp );
        int exc = findMem(sat, ind+1, len, time, dp);

        int val = Integer.max(inc, exc);

        return dp[ind][time] = val;


    }
}
