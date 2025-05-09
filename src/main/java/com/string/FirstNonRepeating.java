package com.string;

import java.util.Arrays;

public class FirstNonRepeating {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(nonRepeatingChar(s));
    }

    static char nonRepeatingChar(String s) {
        // code here
        int[] arr = new int[256];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int j = (int) c;
            int val = arr[j];
            arr[j] = val+1;
            System.out.println("arr[j] "+ arr[j]);
        }

        System.out.println("arr "+ Arrays.toString(arr));

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int j = (int) c;
            if(arr[j] == 1){
                return c;
            }
        }
        return '$';
    }
}
