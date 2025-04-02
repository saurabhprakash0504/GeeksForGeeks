package com.string;

public class CheckSubstring {

    public static void main(String[] args) {
        System.out.println(checkString("aa", "aaa"));
    }


    static boolean checkString(String A, String B){
        /*
            A = gksrek
            B = geeksforgeeks
            Output: True
            Explanation: A is a subsequence of B.
         */
        int j=0;
        char c = A.charAt(j);
        for (int i=0;i< B.length();i++){
            if (c == B.charAt(i)){
                if( j == A.length() -1 ){
                    return true;
                }
                j++;
                c = A.charAt(j);
            }
        }
        return false;
    }
}
