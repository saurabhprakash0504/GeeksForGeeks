package com.string;

public class LongestPallindromicSubstring {

    public static void main(String[] args) {

        LongestPallindromicSubstring obj = new LongestPallindromicSubstring();
        String s = "babad";
        //System.out.println(obj.getLongestPal(s));

        System.out.println(obj.find2(s,s.length()));
    }

    //METHOD 1 - NEETCODE
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

    //METHOD 2 - CODING WITH ALISHA
    String find2(String s, int len){
        int maxLength =1;
        String maxString = String.valueOf(s.charAt(0));

        int[][] dp = new int[len][len];

        for(int i=0;i<len;i++){
            dp[i][i]=1;
        }

        for(int i=0;i<len-1;i++){
            int j=i+1;

            if(s.charAt(i) == s.charAt(j)){
                int tempLen = j-i +1;

                if(tempLen > maxLength){
                    maxLength = tempLen;
                    maxString = s.substring(i,j+1);
                }
                dp[i][j] =2;
            }

        }


        int k=0;
        for(int col = 2; col < len; col++){
            for(int row=0;row<=k;row++){

                if (s.charAt(row) == s.charAt(col)){
                    int val = dp[row+1][col-1];
                    if(val == 0){
                        dp[row][col] = 0;
                    }else{
                        dp[row][col] = val+2;
                        int tempLen = dp[row][col];
                        if(tempLen > maxLength){
                            maxLength = tempLen;
                            maxString = s.substring(row,col+1);
                        }
                    }
                }
            }
            k++;
        }

        return maxString;
    }
}
