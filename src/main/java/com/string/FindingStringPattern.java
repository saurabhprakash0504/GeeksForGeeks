package com.string;

import java.util.ArrayList;

public class FindingStringPattern {

    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba";
        String pat = "a";

        ArrayList<Integer> al = search(pat, txt);
        System.out.println(al.toString());
    }

    static ArrayList<Integer> search(String pat, String txt) {
        // your code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < txt.length(); i++) {

            char c = txt.charAt(i);

            if (c == pat.charAt(0)) {
                int j = i;
                if (validate(pat, txt, j)) {
                    al.add(i);
                }
            }

        }
        return al;
    }


    static boolean validate(String pat, String txt, int index) {
        boolean flag = true;
        int i = 0;
        while (i < pat.length() && (i + index) < txt.length()) {
            if (txt.charAt(index + i) != pat.charAt(i)) {
                flag = false;
                return flag;
            }
            i++;
        }
        if (i != pat.length()) {
            flag = false;
        }
        return flag;

    }

}
