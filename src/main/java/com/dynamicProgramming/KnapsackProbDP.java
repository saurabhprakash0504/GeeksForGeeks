package com.dynamicProgramming;

import java.util.Arrays;

public class KnapsackProbDP {

    public static void main(String[] args) {
        int W = 4, val[] = {1, 2, 3}, wt[] = {4, 5, 1};
        System.out.println(knapsack(W, val, wt));
    }

    static int knapsack(int W, int val[], int wt[]) {
        // code here
        // return find(W, val, wt, 0);

       /* int[][] dp = new int[W+1][val.length+1];
        for(int i=0;i< W+1;i++){
            Arrays.fill(dp[i], -1);
        }

        return findMem(W, val, wt, 0, dp);*/

        //  return findTab(W, val, wt);
        // return findTab2(W, val, wt);
        return findTab2SO(W, val, wt);
    }

    static int find(int w, int val[] ,int[] wt, int ind){

        if(ind >= val.length){
            return 0;
        }

        if(w < 0){
            return 0;
        }

        int inc =0;
        if(wt[ind] <= w)
            inc = val[ind] + find(w-wt[ind], val, wt, ind+1);

        int exc = find(w, val, wt, ind+1);

        return Integer.max(inc, exc);

    }



    static int findMem(int w, int val[] ,int[] wt, int ind, int[][] dp){

        if(ind >= val.length){
            return 0;
        }

        if(w < 0){
            return 0;
        }

        if(dp[w][ind] != -1){
            return dp[w][ind];
        }

        int inc =0;
        if(wt[ind] <= w)
            inc = val[ind] + findMem(w-wt[ind], val, wt, ind+1,dp);

        int exc = findMem(w, val, wt, ind+1, dp);

        return dp[w][ind] = Integer.max(inc, exc);

    }



    static int findTab(int wtt, int val[] ,int[] wt){

        int[][] dp = new int[wtt+1][val.length+1];

        for(int w = 0;w <= wtt;w++){

            for(int ind = wt.length-1;ind >=0 ;ind--){

                int inc =0;
                if(wt[ind] <= w)
                    inc = val[ind] + dp[w-wt[ind]] [ind+1];

                int exc = dp[w] [ind+1];

                dp[w][ind] = Integer.max(inc, exc);


            }
        }


        return dp[wtt][0];
    }


    static int findTab2(int wtt, int val[] ,int[] wt){

        int[][] dp = new int  [val.length+1][wtt+1] ;


        for(int ind = wt.length-1;ind >=0 ;ind--){
            for(int w = 0;w <= wtt;w++){

                int inc =0;
                if(wt[ind] <= w)
                    inc = val[ind] + dp[ind+1] [w-wt[ind]] ;

                int exc = dp[ind+1] [w];

                dp[ind][w] = Integer.max(inc, exc);


            }
        }


        return dp[0][wtt];
    }


    static int findTab2SO(int wtt, int val[] ,int[] wt){

        // int[][] dp = new int  [val.length+1][wtt+1] ;
        int[] next = new int[wtt+1];
        int[] curr = new int[wtt+1];


        for(int ind = wt.length-1;ind >=0 ;ind--){
            for(int w = 0;w <= wtt;w++){

                int inc =0;
                if(wt[ind] <= w)
                    inc = val[ind] + next [w-wt[ind]] ;

                int exc = next [w];

                curr[w] = Integer.max(inc, exc);


            }
            next = curr.clone();
        }


        return next[wtt];
    }

}
