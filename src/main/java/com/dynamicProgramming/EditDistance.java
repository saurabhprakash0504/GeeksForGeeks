package com.dynamicProgramming;

import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {

        EditDistance obj = new EditDistance();
        String s1 = "sunday", s2 = "monday";
        System.out.println(obj.editDistance(s1, s2));
    }

    public int editDistance(String s1, String s2) {
        // Code here
        //  return find(s1, s2, 0, 0);
        int n = s1.length() + 1;
        int m = s2.length() + 1;
        int[][] dp = new int[n][m];
        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        //  return findMem(s1,s2, 0, 0, dp);
        //return findTab(s1,s2);

        return findTabSO(s1, s2);
    }

    int find(String s1, String s2, int i, int j) {
        if (s1.equals(s2)) {
            return 0;
        }
        if (i >= s1.length()) {
            return s2.length() - j;
        }

        if (j >= s2.length()) {
            return s1.length() - i;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return find(s1, s2, i + 1, j + 1);
        }else {

            return Integer.min(1 + find(s1, s2, i, j + 1), Integer.min(1 + find(s1, s2, i + 1, j), 1 + find(s1, s2, i + 1, j + 1)));
        }
    }


    int findMem(String s1, String s2, int i, int j, int[][] dp) {
        if (s1.equals(s2)) {
            return 0;
        }
        if (i >= s1.length()) {
            return s2.length() - j;
        }

        if (j >= s2.length()) {
            return s1.length() - i;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = findMem(s1, s2, i + 1, j + 1, dp);
        } else {

            return dp[i][j] = Integer.min(1 + findMem(s1, s2, i, j + 1, dp), Integer.min(1 + findMem(s1, s2, i + 1, j, dp), 1 + findMem(s1, s2, i + 1, j + 1, dp)));
        }
    }

    int findTab(String s1, String s2) {

        int n = s1.length() + 1;
        int m = s2.length() + 1;
        int[][] dp = new int[n][m];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][s2.length()] = s1.length() - i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            dp[s1.length()][j] = s2.length() - j;
        }


        for (int i = s1.length() - 1; i >= 0; i--) {

            for (int j = s2.length() - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {

                    dp[i][j] = Integer.min(1 + dp[i][j + 1], Integer.min(1 + dp[i + 1][j], 1 + dp[i + 1][j + 1]));
                }

            }

        }

        return dp[0][0];
    }


    int findTabSO(String s1, String s2) {

        int n = s1.length() + 1;
        int m = s2.length() + 1;


        int[] next = new int[m];
        int[] curr = new int[m];

        for (int i = 0; i <= s2.length(); i++) {
            next[i] = s2.length() - i;
        }


        for (int i = s1.length() - 1; i >= 0; i--) {

            for (int j = s2.length() - 1; j >= 0; j--) {
                //check
                curr[s2.length()] = s1.length() - i;
                if (s1.charAt(i) == s2.charAt(j)) {
                    curr[j] = next[j + 1];
                } else {

                    curr[j] = Integer.min(1 + curr[j + 1], Integer.min(1 + next[j], 1 + next[j + 1]));
                }

            }

            next = curr.clone();

        }

        return next[0];
    }
}
