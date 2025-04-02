package com.string;

import java.util.Arrays;

public class LongestSubStringWithDistinctChar {

    public static void main(String[] args) {
       // aabcaaadfazxe
        System.out.println("secondLast >> "+ findLongestSubString2("aabcaaadfazaxe"));
        System.out.println("last  >> "+ longestUniqueSubstring("aabcaaadfazaxe"));
    }




    static int findLongestSubString2(String str){
        int n = str.length();
        int[] prev = new int[256];
        Arrays.fill(prev, -1);
        int startIndex = 0;
        int maxLength = 0;
        int len = 0;
        for (int i=0; i < n ; i++){
            char c = str.charAt(i);
            int index = (int) c;
            if (prev[index] == -1){
                 len = i - startIndex +1;
            } else if (prev [index] > startIndex) {
                 len = i - prev [index];
                startIndex = i;
            } else {
                 len = i - prev [index];

                startIndex =  prev[index] +1;
            }
            maxLength = Integer.max(maxLength, len);
            prev[index] = i;
        }
        return maxLength;
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
