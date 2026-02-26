package com.string;

import java.util.Arrays;

public class LongestSubStringWithDistinctChar {

    public static void main(String[] args) {
        String s = "abcadbd";
        System.out.println(longestUniqueSubstring(s));
    }

    //Correct code
    public static int longestUniqueSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int[] lastIndex = new int[256]; // Assuming extended ASCII characters

        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (lastIndex[currentChar] >= left) {
                left = lastIndex[currentChar] + 1;
            }
            lastIndex[currentChar] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

}
