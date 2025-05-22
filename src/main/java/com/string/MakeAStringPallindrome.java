package com.string;

import java.util.ArrayList;

public class MakeAStringPallindrome {


    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("aabcdd");
        StringBuffer pallindrome = new StringBuffer(s);

        s.append("$");
        for(int i=pallindrome.length()-1;i>=0;i--){
            s.append(pallindrome.charAt(i));
        }
        int[] arr = createLPS(s.toString());
        int val = arr[arr.length-1];
        int data = pallindrome.length() - val;
        System.out.println("data "+ data);
       // StringBuffer pallindrome = new StringBuffer(s);
        for(int i=data-1;i>=0;i--){
            pallindrome.insert(0,pallindrome.charAt(pallindrome.length()-(1+i)));
        }
        System.out.println("pallindrome "+ pallindrome);
    }

    static int[] createLPS(String str) {
        int[] arr = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            ArrayList<String> suffix = createSuffix(str, i);
            ArrayList<String> prefix = createPrefix(str.substring(0,i+1), i);
            int len = findLongestStringLength(suffix, prefix);
            arr[i] = len;
        }

        return arr;
    }

    private static int findLongestStringLength(ArrayList<String> suffix, ArrayList<String> prefix) {
        int maxI = 0;
        for (int i = 0; i < suffix.size(); i++) {
            if (prefix.contains(suffix.get(i))) {
                maxI = Integer.max(maxI, suffix.get(i).length());
            }
        }
        return maxI;
    }

    private static ArrayList<String> createPrefix(String str, int i) {
        ArrayList<String> al = new ArrayList<>();
        al.add("");
        int n = str.length() - 1;
        for (int j = 0; j <= i; j++) {
            al.add(str.substring(j, str.length()));
        }
        return al;
    }

    private static ArrayList<String> createSuffix(String str, int i) {
        ArrayList<String> al = new ArrayList<>();
        al.add("");
        for (int j = 0; j < i; j++) {
            al.add(str.substring(0, j+1));
        }
        return al;
    }
}
