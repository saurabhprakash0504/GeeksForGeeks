package com.dynamicProgramming;

import java.util.Arrays;

public class CatalanNumber {

    public static void main(String[] args) {
        CatalanNumber obj = new CatalanNumber();
        int n = 4;
        System.out.println(obj.findCatalan(n));
    }

    public static int findCatalan(int n) {
        // code here
        // return find(n);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        //return findMem(n, dp);

        return findTab(n);
    }

    static int find(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 0) {
            return 1;
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = ans + (find(i - 1) * find(n - i));
        }

        return ans;
    }


    static int findMem(int n, int[] dp) {

        if (n == 1) {
            return 1;
        }

        if (n == 0) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = ans + (findMem(i - 1, dp) * findMem(n - i, dp));
        }

        return dp[n] = ans;
    }


    static int findTab(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int ans = 0;
            for (int j = 1; j <= i; j++) {
                ans = ans + (dp[j - 1] * dp[i - j]);
            }
            dp[i] = ans;
        }
        return dp[n];
    }
}
