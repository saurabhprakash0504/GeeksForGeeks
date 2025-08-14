package com.dynamicProgramming;

import java.util.*;

public class MinNumberOfCoin {

    public static void main(String[] args) {
        //  int[] arr = {1, 4 ,9 ,12, 15};
        int[] arr = {15, 12, 9, 4, 1};

        System.out.println(minimumNumberOfCoins(arr, arr.length-1 , 27));
    }

    public static long minimumNumberOfCoins(int coins[], int numberOfCoins, int value) {
        // your code here
        long[][] mat = new long[numberOfCoins+1][value+1];
        for(int i=0;i<numberOfCoins+1;i++){
            Arrays.fill(mat[i], -1);
        }
        long val = find(coins, numberOfCoins-1, value, mat);

        if(val == Long.MAX_VALUE){
            val = -1L;
        }

        return val;
    }


   static long find(int coins[], int ind, int sum, long[][] mat) {

        if(sum == 0){
            return 0L;
        }

        if(ind == 0){
            if(sum % coins[0] == 0){
                return sum/coins[0];
            }else{
                return Long.MAX_VALUE;
            }
        }

        if(mat[ind][sum] != -1){
            return mat[ind][sum];
        }

        long noTake = find(coins, ind-1, sum, mat);

        long take= Long.MAX_VALUE;

        if(coins[ind] <= sum){
            long ans = find(coins, ind, sum - coins[ind], mat);

            if(ans < Long.MAX_VALUE){
                take = 1 + ans;
            }
        }

        mat[ind][sum] = Math.min(noTake, take);

        return mat[ind][sum];
    }
}
