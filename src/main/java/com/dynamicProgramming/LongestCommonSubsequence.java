package com.dynamicProgramming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(obj.lcs(s1, s2));
    }

    static int lcs(String s1, String s2) {

        //  return find(s1, s2, 0, 0);
      /*  int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i=0;i< n1+1;i++){
            Arrays.fill(dp[i], -1);
        }

        return findMem(s1, s2, 0, 0, dp);*/

        //  return findTab(s1, s2);

        return findTabSO(s1, s2);

    }

    static int find(String s1, String s2, int i, int j) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + find(s1, s2, i + 1, j + 1);
        } else {
            return Integer.max(find(s1, s2, i + 1, j), find(s1, s2, i, j + 1));
        }
    }


    static int findMem(String s1, String s2, int i, int j, int[][] dp) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + findMem(s1, s2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Integer.max(findMem(s1, s2, i + 1, j, dp), findMem(s1, s2, i, j + 1, dp));
        }
    }


    static int findTab(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = s1.length() - 1; i >= 0; i--) {

            for (int j = s2.length() - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Integer.max(dp[i + 1][j], dp[i][j + 1]);
                }


            }

        }

        return dp[0][0];


    }


    static int findTabSO(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        int[] next = new int[n2 + 1];
        int[] curr = new int[n2 + 1];

        for (int i = s1.length() - 1; i >= 0; i--) {

            for (int j = s2.length() - 1; j >= 0; j--) {

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
