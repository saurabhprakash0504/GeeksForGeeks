package com.dynamicProgramming;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
        String s = "bbabcbcab";
        System.out.println(obj.longestPalinSubseq(s));
    }

    public int longestPalinSubseq(String s1) {
        // code here
        String s2 = new StringBuilder(s1).reverse().toString();
        // return find(s1, s2, 0, 0);

      /*  int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;i++){
            Arrays.fill(dp[i], -1);
        }

        return findMem(s1, s2, 0, 0, dp);*/

        //  return findTab(s1, s2);
        return findTabSO(s1, s2);
    }

    int find(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + find(s1, s2, i + 1, j + 1);
        } else {
            return Integer.max(find(s1, s2, i + 1, j), find(s1, s2, i, j + 1));
        }
    }


    int findMem(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length()) {
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


    int findTab(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

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


    int findTabSO(String s1, String s2) {

        int[] next = new int[s2.length() + 1];
        int[] curr = new int[s2.length() + 1];

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
