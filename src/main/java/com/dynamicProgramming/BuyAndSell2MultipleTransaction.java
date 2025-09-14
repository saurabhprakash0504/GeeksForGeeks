package com.dynamicProgramming;

public class BuyAndSell2MultipleTransaction {

    public static void main(String[] args) {
        BuyAndSell2MultipleTransaction obj = new BuyAndSell2MultipleTransaction();
        int[] arr = {7,1,5,3,6,4};
        System.out.println(obj.maximumProfit(arr));
    }

    public int maximumProfit(int prices[]) {

        // return find(prices, 0, 1);
        // return findGreedy(prices);

      /*  int[][] dp = new int[prices.length+1][2];
        for(int i=0;i<prices.length+1;i++){
            Arrays.fill(dp[i], -1);
        }

        return findMem(prices, 0, 1, dp);*/

        // return findTab(prices);

        return findTabSO(prices);



    }

    int find(int[] prices, int ind, int isBuy){

        if(ind >= prices.length){
            return 0;
        }

        int buy = 0;
        int sell =0;
        if(isBuy == 1){
            buy = Integer.max(-prices[ind]+find(prices, ind+1, 0), find(prices, ind+1, 1));
        }else{
            sell = Integer.max(prices[ind]+find(prices, ind+1, 1), find(prices, ind+1, 0));
        }

        return Integer.max(buy, sell);

    }


    int findMem(int[] prices, int ind, int isBuy, int[][] dp){

        if(ind >= prices.length){
            return 0;
        }

        if(dp[ind][isBuy] != -1){
            return dp[ind][isBuy];
        }

        int buy = 0;
        int sell =0;
        if(isBuy == 1){
            buy = Integer.max(-prices[ind]+findMem(prices, ind+1, 0, dp), findMem(prices, ind+1, 1, dp));
        }else{
            sell = Integer.max(prices[ind]+findMem(prices, ind+1, 1, dp), findMem(prices, ind+1, 0, dp));
        }

        return dp[ind][isBuy]= Integer.max(buy, sell);

    }



    int findTab(int[] prices){

        int[][] dp = new int[prices.length+1][2];

        for(int ind = prices.length-1;ind >=0;ind--){
            for(int isBuy= 0;isBuy <2;isBuy++){
                int buy = 0;
                int sell =0;
                if(isBuy == 1){
                    buy = Integer.max(-prices[ind]+dp[ind+1][0], dp[ind+1][ 1]);
                }else{
                    sell = Integer.max(prices[ind]+dp[ind+1][ 1], dp[ind+1][ 0]);
                }

                dp[ind][isBuy]= Integer.max(buy, sell);
            }
        }



        return dp[0][1];

    }


    int findTabSO(int[] prices){

        int nextInd =0;
        int nextBuy =0;

        int currInd=0;
        int currBuy=0;

        int[] next = new int[2];
        int[] curr = new int[2];

        for(int ind = prices.length-1;ind >=0;ind--){

            for(int isBuy= 0;isBuy <2;isBuy++){
                int buy = 0;
                int sell =0;
                if(isBuy == 1){
                    buy = Integer.max(-prices[ind]+next[0], next[1]);
                }else{
                    sell = Integer.max(prices[ind]+next[ 1], next[ 0]);
                }

                curr[isBuy]= Integer.max(buy, sell);
            }

            next = curr.clone();

        }



        return next[1];

    }



    int findGreedy(int[] prices){
        int sum =0;
        int prev= prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i] - prev > 0){
                sum = sum + (prices[i] - prev);
            }

            prev = prices[i];
        }
        return sum;
    }

}
