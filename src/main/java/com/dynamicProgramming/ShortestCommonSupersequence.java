package com.dynamicProgramming;

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String s1 = "geek", s2 = "eke";
        System.out.println(shortestCommonSupersequence(s1, s2));
    }

    // Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
        int n = s1.length();
        int m = s2.length();
        // int lcsLen = findLCS(s1, s2, 0, 0);


      /*  int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i], -1);
        }

         int lcsLen = findLCSMem(s1, s2, 0, 0, dp);*/

        // int lcsLen = findLCSTab(s1,s2);

        int lcsLen = findLCSTabSO(s1, s2);

        return n + m - lcsLen;

    }

    static int findLCS(String s1, String s2, int i, int j) {

        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + findLCS(s1, s2, i + 1, j + 1);
        } else {
            return Integer.max(findLCS(s1, s2, i + 1, j), findLCS(s1, s2, i, j + 1));
        }
    }


    static int findLCSMem(String s1, String s2, int i, int j, int[][] dp) {

        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + findLCSMem(s1, s2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Integer.max(findLCSMem(s1, s2, i + 1, j, dp), findLCSMem(s1, s2, i, j + 1, dp));
        }
    }


    static int findLCSTab(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];


        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Integer.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }


    static int findLCSTabSO(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();
        int[] next = new int[m + 1];
        int[] curr = new int[m + 1];


        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    curr[j] = 1 + next[j + 1];
                } else {
                    curr[j] = Integer.max(next[j], curr[j + 1]);
                }
            }
            next = curr.clone();
        }

        return next[0];
    }
}