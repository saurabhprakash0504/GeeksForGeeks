package com.dynamicProgramming;

import java.util.Arrays;

public class GuessNumberHigherOrLower2 {

    public static void main(String[] args) {

        GuessNumberHigherOrLower2 obj = new GuessNumberHigherOrLower2();
        int n = 10;
        System.out.println(obj.getMoneyAmount(n));
    }

    public int getMoneyAmount(int n) {
        //  return   find(n, 1, n);

      /*  int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i], -1);
        }

        return findMem(n,1,n,dp);*/

        return findTab(n);
    }

    int find(int n, int start, int end){
        if(start>=end){
            return 0;
        }
        if(start<0){
            return 0;
        }

        if(end>n){
            return 0;
        }



        int ans = Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            ans = Integer.min(ans, i+ Integer.max(find(n, start, i-1), find(n, i+1,end)));
        }

        return ans;
    }


    int findMem(int n, int start, int end, int[][] dp){
        if(start>=end){
            return 0;
        }
        if(start<0){
            return 0;
        }

        if(end>n){
            return 0;
        }

        if(dp[start][end] != -1){
            return dp[start][end];
        }



        int ans = Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            ans = Integer.min(ans, i+ Integer.max(findMem(n, start, i-1, dp), findMem(n, i+1,end, dp)));
        }

        return dp[start][end] = ans;
    }



    int findTab(int n){

        int[][] dp = new int[n+2][n+2];

        for(int start = n;start>=1;start--){
            for(int end = 0;end <=n;end++){
                if(start < end){
                    int ans = Integer.MAX_VALUE;
                    for(int i=start;i<=end;i++){
                        ans = Integer.min(ans, i+ Integer.max(dp[start] [i-1], dp[i+1][end]));
                    }
                    dp[start][end] = ans;
                }
            }
        }

        return dp[1][n];
    }
}
