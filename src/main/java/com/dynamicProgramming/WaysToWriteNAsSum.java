package com.dynamicProgramming;

import java.util.Arrays;

public class WaysToWriteNAsSum {

    public static void main(String[] args) {
        System.out.println(countWays(3));
    }

    static int MOD = 1000000007;

    static int countWays(int n) {

        // your code here
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i], -1);
        }

        return (count(n, n, arr) - 1 + MOD) % MOD;
    }

    static int count(int n, int nn, int[][] arr) {

        if (n == 0) {
            return 1;
        }

        if (n < 0 || nn == 0) {
            return 0;
        }

        if (arr[n][nn] != -1) {
            return arr[n][nn];
        }

       /*   int ways =0;
        for (int i = 1; i <= Math.min(nn, n); i++) {
            ways += count(n - i, i, arr) % MOD;
        }*/

        int ways = (count(n - nn, nn, arr) + count(n, nn - 1, arr)) % MOD;

        arr[n][nn] = ways;
        return arr[n][nn];
    }
}
