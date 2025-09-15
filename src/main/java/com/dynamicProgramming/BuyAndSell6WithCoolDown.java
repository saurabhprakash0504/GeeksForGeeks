package com.dynamicProgramming;

public class BuyAndSell6WithCoolDown {

    public static void main(String[] args) {
        BuyAndSell6WithCoolDown obj = new BuyAndSell6WithCoolDown();
        long[] arr = {1, 2, 3, 0, 2};
        int N = arr.length;
        System.out.println(obj.maximumProfit(arr, N));
    }

    public long maximumProfit(long prices[], int N) {
        // Code here
        //return find(prices, 0, 1);

      /*  long[][] dp = new long [prices.length+1][2];
        for(int i=0;i< prices.length+1;i++){
            Arrays.fill(dp[i], -1);
        }
        return findMem(prices, 0, 1 ,dp);*/

        //  return findTab(prices);

        return findTabSO(prices);
    }

    long find(long[] arr, int ind, int isBuy){
        if(ind >= arr.length){
            return 0;
        }

        //int profit=0;
        long buy =0;
        long sell =0;

        if(isBuy == 1){
            buy = Math.max(-arr[ind] + find(arr, ind+1, 0), find(arr, ind+1, 1));
        }else{
            sell = Math.max(arr[ind] + find(arr, ind+2, 1), find(arr, ind+1, 0));
        }

        return Math.max(buy, sell);
    }

    long findMem(long[] arr, int ind, int isBuy, long[][] dp){
        if(ind >= arr.length){
            return 0;
        }

        if(dp[ind][isBuy] != -1){
            return dp[ind][isBuy];
        }

        //int profit=0;
        long buy =0;
        long sell =0;

        if(isBuy == 1){
            buy = Math.max(-arr[ind] + findMem(arr, ind+1, 0, dp), findMem(arr, ind+1, 1, dp));
        }else{
            sell = Math.max(arr[ind] + findMem(arr, ind+2, 1, dp), findMem(arr, ind+1, 0, dp));
        }

        return dp[ind][isBuy] = Math.max(buy, sell);
    }

    long findTab(long[] arr){

        long[][] dp = new long [arr.length+2][2];

        for(int ind=arr.length-1;ind >=0;ind--){
            for(int isBuy=0;isBuy<2;isBuy++){
                long buy =0;
                long sell =0;

                if(isBuy == 1){
                    buy = Math.max(-arr[ind] + dp[ ind+1][ 0], dp[ind+1][ 1]);
                }else{
                    sell = Math.max(arr[ind] + dp[ind+2][ 1], dp[ind+1][0]);
                }

                dp[ind][isBuy] = Math.max(buy, sell);
            }
        }
        return dp[0][1] ;
    }


    long findTabSO(long[] arr){


        long[] next = new long[2];
        long[] next2 = new long[2];
        long[] curr = new long[2];

        for(int ind=arr.length-1;ind >=0;ind--){
            for(int isBuy=0;isBuy<2;isBuy++){
                long buy =0;
                long sell =0;

                if(isBuy == 1){
                    buy = Math.max(-arr[ind] +next[ 0], next[ 1]);
                }else{
                    sell = Math.max(arr[ind] + next2[ 1], next[0]);
                }

                curr[isBuy] = Math.max(buy, sell);
            }
            next2 = next.clone();
            next = curr.clone();
        }
        return next[1] ;
    }
}
