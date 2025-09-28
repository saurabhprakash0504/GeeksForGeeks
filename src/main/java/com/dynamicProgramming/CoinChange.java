package com.dynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        int coins[] = {1, 2, 3};
        int val = 5;
        int numberOfCoins = coins.length;

        CoinChange obj = new CoinChange();
        System.out.println(obj.minimumNumberOfCoins(coins, numberOfCoins, val));
    }

    public long minimumNumberOfCoins(int coins[], int numberOfCoins, int val) {
        // your code here
        // Long res = find(0, val,coins,numberOfCoins);

        long[][] dp = new long[numberOfCoins + 1][val + 1];
        for (int i = 0; i < numberOfCoins + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        Long res = findMem(0, val, coins, numberOfCoins, dp);
        if (res == Long.MAX_VALUE) {
            return -1L;
        } else {
            return res;
        }
    }


    long find(int ind, int val, int[] coins, int len) {
        if (ind == len) {
            return Long.MAX_VALUE;
        }

        if (val == 0) {
            return 0L;
        }


        long inc = Integer.MAX_VALUE;
        if (val >= coins[ind]) {
            long vals = find(ind, val - coins[ind], coins, len);
            if (vals != Long.MAX_VALUE) {
                inc = 1 + vals;
            }
        }
        long exc = find(ind + 1, val, coins, len);


        // max = Long.min(max, Long.min(inc, exc));

        return Long.min(inc, exc);
    }

    long findMem(int ind, int val, int[] coins, int len, long[][] dp) {
        if (ind == len) {
            return Long.MAX_VALUE;
        }

        if (val == 0) {
            return 0L;
        }

        if (dp[ind][val] != -1) {
            return dp[ind][val];
        }

        long inc = Long.MAX_VALUE;
        if (val >= coins[ind]) {
            long vals = findMem(ind, val - coins[ind], coins, len, dp);
            if (vals != Long.MAX_VALUE) {
                inc = 1 + vals;
            }
        }
        long exc = findMem(ind + 1, val, coins, len, dp);


        // max = Long.min(max, Long.min(inc, exc));

        return dp[ind][val] = Long.min(inc, exc);
    }
}
