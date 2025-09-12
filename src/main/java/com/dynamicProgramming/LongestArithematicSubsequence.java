package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestArithematicSubsequence {

    public static void main(String[] args) {
        LongestArithematicSubsequence obj = new LongestArithematicSubsequence();
        Integer[] arr = {1, 7, 10, 13, 14, 19};
        System.out.println(obj.lengthOfLongestAP(arr));
    }

    int lengthOfLongestAP(Integer[] arr) {
        // code here
        //return find(arr, arr.length);

        // return findRec(arr, arr.length);

        return findTabulation(arr, arr.length);

    }



    int find(Integer[] arr, int n){
        if(n==1){
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i< n ;i++){
            for(int j=i+1;j<n;j++){
                int diff = arr[j]- arr[i];
                ArrayList<Integer> al = new ArrayList<Integer>();
                al.add(arr[j]);
                al.add(arr[i]);
                for(int k=i-1;k>=0;k--){
                    if(al.get(al.size()-1)-arr[k] == diff){
                        al.add(arr[k]);
                    }
                }
                max = Integer.max(max, al.size());
            }
        }

        return max;
    }


    int findRec(Integer[] arr, int n){
        if(n==1){
            return 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i< n ;i++){
            for(int j=i+1;j<n;j++){
                int diff = arr[j]- arr[i];


                max = Integer.max(max, 2+rec(diff, i, arr));
            }
        }

        return max;
    }

    int rec(int diff, int ind, Integer[] arr){
        if(ind <0){
            return 0;
        }

        int ans =0;
        for(int k=ind-1;k>=0;k--){
            if(arr[ind] - arr[k] == diff){
                ans = Integer.max(ans, 1 + rec(diff, k, arr));
            }
        }

        return ans;
    }



    int findMem(Integer[] arr, int n){
        if(n==1){
            return 1;
        }
        int max = Integer.MIN_VALUE;

        HashMap<Integer, HashMap<Integer, Integer>> memo =
                new HashMap<>();
        for(int i=0;i< n ;i++){
            for(int j=i+1;j<n;j++){
                int diff = arr[j]- arr[i];


                max = Integer.max(max, 2+recMem(diff, i, arr, memo));
            }
        }

        return max;
    }

    int recMem(int diff, int ind, Integer[] arr,HashMap<Integer, HashMap<Integer, Integer>> memo ){
        if(ind <0){
            return 0;
        }

        // Check memo table for precomputed result
        if (memo.containsKey(ind) &&
                memo.get(ind).containsKey(diff)) {
            return memo.get(ind).get(diff);
        }

        int ans =0;
        for(int k=ind-1;k>=0;k--){
            if(arr[ind] - arr[k] == diff){
                ans = Integer.max(ans, 1 + recMem(diff, k, arr, memo));
            }
        }

        //return ans;

        memo.putIfAbsent(ind, new HashMap<>());
        memo.get(ind).put(diff, ans);

        return ans;
    }


    int findTabulation(Integer[] arr, int n) {
        if (n == 1) return 1;

        int ans = 0;
        // Using same style: outer key = index, inner map = (diff → length)
        HashMap<Integer, HashMap<Integer, Integer>> dp = new HashMap<>();

        for(int i=1;i<n;i++){
            dp.putIfAbsent(i, new HashMap<>());
            for(int j=0;j<i;j++){
                int diff = arr[i]- arr[j];
                int cnt =1;

                if(dp.containsKey(j) && dp.get(j).containsKey(diff)){
                    cnt = dp.get(j).get(diff);
                }

                HashMap<Integer, Integer> map = dp.get(i);
                map.put(diff, 1+cnt);
                ans = Integer.max(ans, dp.get(i).get(diff));

            }
        }



        return ans;
    }
}
