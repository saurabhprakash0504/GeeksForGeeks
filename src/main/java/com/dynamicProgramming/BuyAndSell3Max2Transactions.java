package com.dynamicProgramming;

import java.util.Arrays;

public class BuyAndSell3Max2Transactions {

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        // code here
        // return find(prices, 0, 1, 2);

        int[][][] dp = new int[prices.length+1][2][3];

        for(int i=0;i<prices.length+1;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        // return findMem(prices, 0, 1, 2, dp);

        // return findTab(prices);

        return findTabSO(prices);
    }

    static int find(int[] prices, int ind, int isBuy, int limit){

        if(ind >= prices.length){
            return 0;
        }

        if(limit ==0 ){
            return 0;
        }

        int buy =0;
        int sell =0;
        if(isBuy ==1 ){

            buy = Integer.max(-prices[ind] + find(prices, ind+1, 0, limit), find(prices, ind+1,1,limit));


        }else if(isBuy ==0 ){

            sell = Integer.max(prices[ind] + find(prices, ind+1, 1, limit-1), find(prices, ind+1,0,limit));


        }

        return  Integer.max(buy, sell);
    }


    static int findMem(int[] prices, int ind, int isBuy, int limit, int[][][] dp){

        if(ind >= prices.length){
            return 0;
        }

        if(limit ==0 ){
            return 0;
        }

        if(dp[ind][isBuy][limit] !=-1){
            return dp[ind][isBuy][limit];
        }

        int buy =0;
        int sell =0;
        if(isBuy ==1 ){

            buy = Integer.max(-prices[ind] + findMem(prices, ind+1, 0, limit, dp), findMem(prices, ind+1,1,limit, dp));


        }else if(isBuy ==0 ){

            sell = Integer.max(prices[ind] + findMem(prices, ind+1, 1, limit-1, dp), findMem(prices, ind+1,0,limit, dp));


        }

        return  dp[ind][isBuy][limit]= Integer.max(buy, sell);
    }


    static int findTab(int[] prices){

        int[][][] dp = new int[prices.length+1][2][3];

        for(int ind = prices.length-1 ;ind>=0;ind--){
            for(int isBuy= 0;isBuy <=1;isBuy++){
                for(int limit= 1; limit<=2;limit++){
                    int buy =0;
                    int sell =0;
                    if(isBuy ==1 ){

                        buy = Integer.max(-prices[ind] + dp[ind+1][0][limit], dp[ind+1][1][limit]);


                    }else if(isBuy ==0 ){

                        sell = Integer.max(prices[ind] + dp[ind+1][1][limit-1], dp[ind+1][0][limit]);


                    }

                    dp[ind][isBuy][limit]= Integer.max(buy, sell);
                }
            }
        }

        return dp[0][1][2];

    }


    static int findTabSO(int[] prices){

        int[][] next = new int[2][3];
        int[][] curr = new int[2][3];

        for(int ind = prices.length-1 ;ind>=0;ind--){
            for(int isBuy= 0;isBuy <=1;isBuy++){
                for(int limit= 1; limit<=2;limit++){
                    int buy =0;
                    int sell =0;
                    if(isBuy ==1 ){

                        buy = Integer.max(-prices[ind] + next[0][limit], next[1][limit]);


                    }else if(isBuy ==0 ){

                        sell = Integer.max(prices[ind] + next[1][limit-1], next[0][limit]);


                    }

                    curr[isBuy][limit]= Integer.max(buy, sell);
                }
            }
            next = curr.clone();
        }

        return next[1][2];

    }
}
