package com.dynamicProgramming;

import java.util.ArrayList;

public class LongestArithematicSubsequence {

    public static void main(String[] args) {
        LongestArithematicSubsequence obj = new LongestArithematicSubsequence();
        Integer[] arr = {1, 7, 10, 13, 14, 19};
        System.out.println(obj.lengthOfLongestAP(arr));
    }

    int lengthOfLongestAP(Integer[] arr) {
        return find(arr);
    }

    int find(Integer[] arr){
        if(arr.length == 1){
            return 1;
        }
        int max = 0;
        for(int i=0;i<arr.length-1;i++){
            for(int k =i+1;k< arr.length;k++){
                int diff = arr[k]- arr[i];
                ArrayList<Integer> al = new ArrayList<>();
                al.add(arr[k]);
                al.add(arr[i]);
                for(int j =i-1;j>=0;j--){
                    if((al.get(al.size()-1) - arr[j]) == diff){
                        al.add(arr[j]);
                    }
                }
                // System.out.println("al >>"+al);
                max = Integer.max(max, al.size());
            }


        }
        return max;
    }
}
