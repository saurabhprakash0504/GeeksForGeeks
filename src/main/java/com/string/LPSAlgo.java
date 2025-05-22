package com.string;

import java.util.Arrays;

public class LPSAlgo {

    public static void main(String[] args) {
        String s = "AAABAAAAC";
        int[] lps = new int[s.length()];
        createLPS(s, lps);
        System.out.println("Arrays "+ Arrays.toString(lps));
    }


    static void createLPS(String input, int[] lps) {
        if (input.length() == 0) {
            return;
        }

        int len = 0;
        lps[0] = 0;

        for (int i = 1; i < lps.length; i++) {
            char c = input.charAt(i);
            len = lps[i - 1];
            if (input.charAt(len) == c) {
                lps[i] = len + 1;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                } else {

                    len = lps[len - 1];

                }
            }
        }
    }
}
