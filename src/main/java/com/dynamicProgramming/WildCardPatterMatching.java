package com.dynamicProgramming;

public class WildCardPatterMatching {

    public static void main(String[] args) {

        String txt = "baaabab";
        String pat = "*****ba*****ab";

        WildCardPatterMatching obj = new WildCardPatterMatching();

        System.out.println(obj.wildCard(txt, pat));
    }

    public boolean wildCard(String txt, String pat) {
        // Your code goes here

        // return find(txt, pat, txt.length()-1, pat.length()-1);

        //   Boolean[][] dp = new Boolean[txt.length()][pat.length()];

        //   return findMem(txt, pat, txt.length()-1, pat.length()-1, dp);

        // Boolean[][] dp = new Boolean[txt.length()+1][pat.length()+1];
        // return findMemShifting(txt, pat, txt.length(), pat.length(), dp);


        // return findTab(txt, pat);

        return findTabSO(txt, pat);


    }


    boolean find(String txt, String pat, int i, int j) {

        if (i < 0 && j < 0) {
            return true;
        }

        if (i >= 0 && j < 0) {
            return false;
        }

        if (j >= 0 && i < 0) {

            for (int k = 0; k <= j; k++) {
                if (pat.charAt(k) != '*') {
                    return false;
                }
            }

            return true;

        }

        //match
        if (txt.charAt(i) == pat.charAt(j)) {
            return find(txt, pat, i - 1, j - 1);
        }

        if (pat.charAt(j) == '?') {
            return find(txt, pat, i - 1, j - 1);
        }

        // * pattern
        if (pat.charAt(j) == '*') {
            //Empty pattern char || Any char
            return find(txt, pat, i, j - 1) || find(txt, pat, i - 1, j);
        } else {
            return false;
        }

    }


    boolean findMem(String txt, String pat, int i, int j, Boolean[][] dp) {

        if (i < 0 && j < 0) {
            return true;
        }

        if (i >= 0 && j < 0) {
            return false;
        }

        if (j >= 0 && i < 0) {

            for (int k = 0; k <= j; k++) {
                if (pat.charAt(k) != '*') {
                    return false;
                }
            }

            return true;

        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        //match
        if (txt.charAt(i) == pat.charAt(j)) {
            return dp[i][j] = findMem(txt, pat, i - 1, j - 1, dp);
        }

        if (pat.charAt(j) == '?') {
            return dp[i][j] = findMem(txt, pat, i - 1, j - 1, dp);
        }

        // * pattern
        if (pat.charAt(j) == '*') {
            //Empty pattern char || Any char
            return dp[i][j] = findMem(txt, pat, i, j - 1, dp) || findMem(txt, pat, i - 1, j, dp);
        } else {
            return dp[i][j] = false;
        }

    }


    boolean findMemShifting(String txt, String pat, int i, int j, Boolean[][] dp) {

        if (i == 0 && j == 0) {
            return true;
        }

        if (i > 0 && j == 0) {
            return false;
        }

        if (j > 0 && i == 0) {

            for (int k = 1; k <= j; k++) {
                if (pat.charAt(k - 1) != '*') {
                    return false;
                }
            }

            return true;

        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        //match
        if (txt.charAt(i - 1) == pat.charAt(j - 1)) {
            return dp[i][j] = findMemShifting(txt, pat, i - 1, j - 1, dp);
        }

        if (pat.charAt(j - 1) == '?') {
            return dp[i][j] = findMemShifting(txt, pat, i - 1, j - 1, dp);
        }

        // * pattern
        if (pat.charAt(j - 1) == '*') {
            //Empty pattern char || Any char
            return dp[i][j] = findMemShifting(txt, pat, i, j - 1, dp) || findMemShifting(txt, pat, i - 1, j, dp);
        } else {
            return dp[i][j] = false;
        }

    }


    boolean findTab(String str, String pat) {


        boolean[][] dp = new boolean[str.length() + 1][pat.length() + 1];

        dp[0][0] = true;

        for (int i = 1; i <= str.length(); i++) {
            dp[i][0] = false;
        }


        for (int j = 1; j <= pat.length(); j++) {
            boolean flag = true;
            for (int k = 1; k <= j; k++) {
                if (pat.charAt(k - 1) != '*') {
                    flag = false;
                }
            }

            dp[0][j] = flag;

        }


        for (int i = 1; i <= str.length(); i++) {

            for (int j = 1; j <= pat.length(); j++) {
                //match
                if (str.charAt(i - 1) == pat.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pat.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // * pattern
                else if (pat.charAt(j - 1) == '*') {
                    //Empty pattern char || Any char
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }


            }

        }

        return dp[str.length()][pat.length()];

    }


    boolean findTabSO(String str, String pat) {

        boolean[] prev = new boolean[pat.length() + 1];
        boolean[] curr = new boolean[pat.length() + 1];


        prev[0] = true;

        for (int i = 1; i <= str.length(); i++) {
            curr[0] = false;
        }


        for (int j = 1; j <= pat.length(); j++) {
            boolean flag = true;
            for (int k = 1; k <= j; k++) {
                if (pat.charAt(k - 1) != '*') {
                    flag = false;
                }
            }

            prev[j] = flag;

        }


        for (int i = 1; i <= str.length(); i++) {

            for (int j = 1; j <= pat.length(); j++) {
                //match
                if (str.charAt(i - 1) == pat.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else if (pat.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                }

                // * pattern
                else if (pat.charAt(j - 1) == '*') {
                    //Empty pattern char || Any char
                    curr[j] = curr[j - 1] || prev[j];
                } else {
                    curr[j] = false;
                }


            }

            prev = curr.clone();

        }

        return prev[pat.length()];

    }

}
