package com.dynamicProgramming;

import java.util.HashMap;

public class LongestAPWithGivenDiffD {

    public static void main(String[] args) {
        LongestAPWithGivenDiffD obj = new LongestAPWithGivenDiffD();
        int[] arr = {1, 2, 3, 4};
        int diff = 1;
        System.out.println(obj.longestSubsequence(arr, diff));
    }

    public int longestSubsequence(int[] arr, int diff) {
        // return find(arr, 0, -1, diff);

        int n = arr.length;
        // int[][] dp = new int[n+1][n+1];
        // for(int i=0;i<=n;i++)
        // Arrays.fill(dp[i], -1);
        //return findMem(arr, 0, -1, diff, dp);

        return longestSubsequence3(arr, diff);

    }

    int find(int[] arr, int ind, int maxInd, int diff){

        if(ind >= arr.length){
            return 0;
        }

        //inc
        int count =0;
        if(maxInd == -1 || arr[ind] - arr[maxInd] == diff ){
            count = 1+  find(arr, ind+1, ind, diff);
        }

        //exc
        int exc = find(arr, ind+1, maxInd, diff);

        return Integer.max(count, exc);

    }


    static int findMem(int[] arr, int ind, int maxInd, int diff, int[][] dp){
        if(ind >= arr.length){
            return 0;
        }

        if(maxInd != -1 && dp[ind][maxInd] != -1){
            return dp[ind][maxInd];
        }

        //inc
        int count =0;
        if(maxInd == -1 || arr[ind] - arr[maxInd] == diff){
            count = 1+  findMem(arr, ind+1, ind, diff, dp);
        }

        //exc
        int exc = findMem(arr, ind+1, maxInd, diff, dp);

        if(maxInd != -1)
            return dp[ind][maxInd] = Integer.max(count, exc);
        else
            return Integer.max(count, exc);
    }


    public int longestSubsequence3(int[] arr, int diff) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxi = 1;
        for(int i: arr){
            int d = i - diff;
            if(map.containsKey(d)){
                int val = map.get(d);
                maxi= Integer.max(maxi, val+1);
                map.put(i, val+1);
            }else{
                map.put(i,1);
            }
        }
        return maxi;
    }
}
