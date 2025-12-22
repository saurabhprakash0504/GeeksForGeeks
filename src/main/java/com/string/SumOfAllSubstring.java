package com.string;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubstring {

    public static void main(String[] args) {

        String s = "1234";
        int result = sumSubstrings(s);
        System.out.println(result); // Output: 1670
    }

     /* public static int sumSubstrings(String s) {
        // code here
        char[] arr = s.toCharArray();
        int len = s.length();

        //int ind=1;
        int sum = 0;
        for(int i=1;i<= len;i++){

            for(int j = 0;j<=len;j++){
                if(j+i <= len){
                    String tem = s.substring(j, j+i);

                    int a = Integer.parseInt(tem);
                    sum = sum+a;
                }
            }

        }
        return sum;
    }*/


    //new

    public static int sumSubstrings(String s) {
        // code here

        List<String> res = findSubstrings(s);
        int sum = 0;

        for (String str : res) {

            sum = sum + Integer.parseInt(str);

        }

        return sum;

    }

    static void subString(String s, int n, int index, StringBuilder cur, List<String> res) {

        // if we have reached the
        // end of the string
        if (index == n) {
            return;
        }

        // add the character s.charAt(index)
        // to the current string
        cur.append(s.charAt(index));

        // add the current string in result
        res.add(cur.toString());

        // move to next index
        subString(s, n, index + 1, cur, res);

        // remove the current character
        // from the current string
        cur.deleteCharAt(cur.length() - 1);

        // if current string is empty
        // skip the current index to
        // start the new substring
        if (cur.length() == 0) {
            subString(s, n, index + 1, cur, res);
        }
    }

    // Function to find all substrings
    static List<String> findSubstrings(String s) {

        // to store all substrings
        List<String> res = new ArrayList<>();

        // to store current string
        StringBuilder cur = new StringBuilder();
        subString(s, s.length(), 0, cur, res);
        return res;
    }
}
