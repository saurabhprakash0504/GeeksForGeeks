package com.dynamicProgramming;

import java.util.Arrays;

public class Pizza3NSlice {

    public static void main(String[] args) {
        int[] slices = {1,2,3,4,5,6};
        Pizza3NSlice obj = new Pizza3NSlice();
        System.out.println(obj.maxSizeSlices(slices));
    }

    public int maxSizeSlices(int[] slices) {
        int len = slices.length;
        int k = len/3;
        int[][] dp1 = new int[len+1][k+1];
        for(int i=0;i<=len;i++){
            Arrays.fill(dp1[i],-1);
        }

        int[][] dp2 = new int[len+1][k+1];
        for(int i=0;i<=len;i++){
            Arrays.fill(dp2[i],-1);
        }

        int val1 = findMem(slices, len-2, 0,  k, dp1);
        int val2 = findMem(slices, len-1, 1,  k, dp2);
        //return Integer.max(val1, val2);

        return findTab(slices, len);
    }

    int find(int[] arr, int len, int ind, int k){

        if(k == 0){
            return 0;
        }

        if(ind >= len){
            return 0;
        }

        int inc = arr[ind]+find(arr, len, ind+2, k-1);
        int exc = find(arr, len, ind+1, k);

        return Integer.max(inc, exc);
    }


    int findMem(int[] arr, int len, int ind, int k, int[][] dp){

        if(k == 0){
            return 0;
        }

        if(ind > len){
            return 0;
        }

        if(dp[ind][k] != -1){
            return dp[ind][k];
        }

        int inc = arr[ind]+findMem(arr, len, ind+2, k-1, dp);
        int exc = findMem(arr, len, ind+1, k, dp);

        return dp[ind][k]=Integer.max(inc, exc);
    }



    int findTab(int[] arr, int len){
        int s = len/3;
        int n = len;
        int[][] dp1 = new int[len+2][s+1];
        for(int i=0;i<=len;i++){
            Arrays.fill(dp1[i],0);
        }

        int[][] dp2 = new int[len+2][s+1];
        for(int i=0;i<=len;i++){
            Arrays.fill(dp2[i],0);
        }

        for(int ind=n-2;ind>=0;ind--){
            for(int k=len/3;k>=0;k--){
                int inc =0;
                if(k!=0)
                    inc = arr[ind]+dp1[ind+2][k-1];
                int exc = dp1[ind+1][k];

                dp1[ind][k]=Integer.max(inc, exc);
            }
        }

        for(int ind=n-1;ind>=1;ind--){
            for(int k=len/3;k>=0;k--){
                int inc = 0;
                if(k!=0)
                    inc = arr[ind]+dp2[ind+2][k-1];
                int exc = dp2[ind+1][k];

                dp2[ind][k]=Integer.max(inc, exc);
            }
        }
        return Integer.max(dp1[0][s], dp2[1][s]);
    }
}
