package com.dynamicProgramming;

public class SumOfAllSubString {

    public static void main(String[] args) {
        String s = "123";

        System.out.println(sumSubstrings(s));
    }

    public static int sumSubstrings(String s) {
        return recurse(s, 0, 0);
    }

    private static int recurse(String s, int idx, int prev) {
        if (idx == s.length()) return 0;

        int digit = s.charAt(idx) - '0';
        int curr = prev * 10 + (idx + 1) * digit;

        return curr + recurse(s, idx + 1, curr);
    }

}
