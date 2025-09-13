package com.dynamicProgramming;

import java.util.Arrays;

public class MinimumCostTreeFromLeafValues {

    public static void main(String[] args) {

        MinimumCostTreeFromLeafValues obj = new MinimumCostTreeFromLeafValues();
        int[] arr = {6,2,4};
        System.out.println(obj.mctFromLeafValues(arr));

    }

    public int mctFromLeafValues(int[] arr) {
        int[][] maxLen = new int[arr.length][arr.length];
        preComputeMaxValueTillIndex(arr, maxLen);

        // return find(arr, maxLen, 0, arr.length-1);

        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int i=0;i<arr.length+1;i++){
            Arrays.fill(dp[i], -1);
        }

        return findMem(arr, maxLen, 0, arr.length-1, dp);
    }


    void preComputeMaxValueTillIndex(int[] arr, int[][] maxLen){
        for(int i=0;i<arr.length;i++){

            maxLen[i][i] = arr[i];

            for(int j=i+1;j<arr.length;j++){
                int max = Integer.max(arr[j], maxLen[i][j-1]);
                maxLen[i][j] = max;
            }
        }
    }


    int find(int[] arr, int[][] maxLen , int start, int end ){

        if(start >= end){
            return 0;
        }

        int ans=Integer.MAX_VALUE;
        for(int i=start;i<end;i++){
            int max1 = maxLen[start][i];
            int max2 = maxLen[i+1][end];
            ans = Integer.min(ans, max1 * max2 + find(arr, maxLen, start, i) + find(arr, maxLen, i+1, end));
        }

        return ans;

    }


    int findMem(int[] arr, int[][] maxLen , int start, int end, int[][] dp){

        if(start >= end){
            return 0;
        }

        if(dp[start][end]!=-1){
            return dp[start][end];
        }

        int ans=Integer.MAX_VALUE;
        for(int i=start;i<end;i++){
            int leftMax = maxLen[start][i];
            int rightMax = maxLen[i+1][end];
            ans = Integer.min(ans, leftMax * rightMax + findMem(arr, maxLen, start, i, dp) + findMem(arr, maxLen, i+1, end, dp));
        }

        return dp[start][end]=ans;

    }

}
