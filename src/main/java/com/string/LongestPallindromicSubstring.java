package com.string;

public class LongestPallindromicSubstring {

    public static void main(String[] args) {

        LongestPallindromicSubstring obj = new LongestPallindromicSubstring();
        String s = "babad";
        System.out.println(obj.getLongestPal(s));
    }

    public String getLongestPal(String s) {
        // code here
        return find(s);
    }

    String find(String s) {
        int maxLen = 1;
        char c = s.charAt(0);
        String maxString = String.valueOf(c);
        int len = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            int l1 = 0;
            int start = i - 1;
            int end = i + 1;

            while (start >= 0 && end <= len && s.charAt(start) == s.charAt(end)) {
                l1 = end - start + 1;
                if (l1 > maxLen) {
                    maxLen = l1;
                    maxString = s.substring(start, end + 1);
                }
                start--;
                end++;
            }


            //even length
            int l2 = 0;
            start = i;
            end = i + 1;

            while (start >= 0 && end <= len && s.charAt(start) == s.charAt(end)) {
                l2 = end - start + 1;
                if (l2 > maxLen) {
                    maxLen = l2;
                    maxString = s.substring(start, end + 1);
                }
                start--;
                end++;
            }


        }

        return maxString;

    }
}
