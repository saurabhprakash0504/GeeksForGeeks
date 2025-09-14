package com.dynamicProgramming;

public class BuyAndSell4MaxNTransactions {

    public static void main(String[] args) {

        int[] prices = {3,3,5,0,0,3,1,4};
        int k = 2;
        System.out.println(maxProfit(prices, k));
    }

    static int maxProfit(int prices[], int k) {
        // code here
        // return find(prices, k, 0, 1);

       /* int[][][] dp = new int[k+1][prices.length+1][2];
        for(int i=0;i<k+1;i++){
            for(int j=0;j<prices.length+1;j++){
               Arrays.fill(dp[i][j],-1);
            }
        }

         return findMem(prices, k, 0, 1, dp);*/

        // return findTab(prices, k);

        return findTabSO(prices, k);

        // return find2(prices,k, 0,0);

      /*  int[][] dp = new int[prices.length+1][k*2+1];
        for(int i=0;i<prices.length+1;i++){
            Arrays.fill(dp[i], -1);
        }

        return find2Mem(prices, k, 0, 0, dp);*/

        //return find2Tab(prices, k);
        // return find2TabSO(prices, k);
    }


    static int find(int prices[], int k, int ind, int isBuy) {
        if (ind >= prices.length) {
            return 0;
        }

        if (k <= 0) {
            return 0;
        }

        int buy = 0;
        int sell = 0;
        if (isBuy == 1) {
            buy = Integer.max(-prices[ind] + find(prices, k, ind + 1, 0), find(prices, k, ind + 1, 1));
        } else {
            sell = Integer.max(prices[ind] + find(prices, k - 1, ind + 1, 1), find(prices, k, ind + 1, 0));
        }

        return Integer.max(buy, sell);
    }


    static int findMem(int prices[], int k, int ind, int isBuy, int[][][] dp) {
        if (ind >= prices.length) {
            return 0;
        }

        if (k <= 0) {
            return 0;
        }

        if (dp[k][ind][isBuy] != -1) {
            return dp[k][ind][isBuy];
        }

        int buy = 0;
        int sell = 0;
        if (isBuy == 1) {
            buy = Integer.max(-prices[ind] + findMem(prices, k, ind + 1, 0, dp), findMem(prices, k, ind + 1, 1, dp));
        } else {
            sell = Integer.max(prices[ind] + findMem(prices, k - 1, ind + 1, 1, dp), findMem(prices, k, ind + 1, 0, dp));
        }

        return dp[k][ind][isBuy] = Integer.max(buy, sell);
    }

    static int findTab(int[] prices, int k) {

        int[][][] dp = new int[prices.length + 1][2][k + 1];

        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int isBuy = 0; isBuy <= 1; isBuy++) {
                for (int limit = 1; limit <= k; limit++) {
                    int buy = 0;
                    int sell = 0;
                    if (isBuy == 1) {

                        buy = Integer.max(-prices[ind] + dp[ind + 1][0][limit], dp[ind + 1][1][limit]);


                    } else if (isBuy == 0) {

                        sell = Integer.max(prices[ind] + dp[ind + 1][1][limit - 1], dp[ind + 1][0][limit]);


                    }

                    dp[ind][isBuy][limit] = Integer.max(buy, sell);
                }
            }
        }

        return dp[0][1][k];

    }


    static int findTabSO(int[] prices, int k) {

        int[][] next = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];

        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int isBuy = 0; isBuy <= 1; isBuy++) {
                for (int limit = 1; limit <= k; limit++) {
                    int buy = 0;
                    int sell = 0;
                    if (isBuy == 1) {

                        buy = Integer.max(-prices[ind] + next[0][limit], next[1][limit]);


                    } else if (isBuy == 0) {

                        sell = Integer.max(prices[ind] + next[1][limit - 1], next[0][limit]);


                    }

                    curr[isBuy][limit] = Integer.max(buy, sell);
                }
            }
            next = curr.clone();
        }

        return next[1][k];

    }


    static int find2(int prices[], int k, int ind, int noOfTransaction) {
        if (ind >= prices.length) {
            return 0;
        }

        if (noOfTransaction > k * 2) {
            return 0;
        }


        int buy = 0;
        int sell = 0;
        if (noOfTransaction % 2 == 0) {
            buy = Integer.max(-prices[ind] + find2(prices, k, ind + 1, noOfTransaction + 1), find2(prices, k, ind + 1, noOfTransaction));
        } else {
            sell = Integer.max(prices[ind] + find2(prices, k, ind + 1, noOfTransaction + 1), find2(prices, k, ind + 1, noOfTransaction));
        }

        return Integer.max(buy, sell);
    }


    static int find2Mem(int prices[], int k, int ind, int noOfTransaction, int[][] dp) {
        if (ind >= prices.length) {
            return 0;
        }

        if (noOfTransaction > k * 2) {
            return 0;
        }

        if (dp[ind][noOfTransaction] != -1) {
            return dp[ind][noOfTransaction];
        }


        int buy = 0;
        int sell = 0;
        if (noOfTransaction % 2 == 0) {
            buy = Integer.max(-prices[ind] + find2Mem(prices, k, ind + 1, noOfTransaction + 1, dp), find2Mem(prices, k, ind + 1, noOfTransaction, dp));
        } else {
            sell = Integer.max(prices[ind] + find2Mem(prices, k, ind + 1, noOfTransaction + 1, dp), find2Mem(prices, k, ind + 1, noOfTransaction, dp));
        }

        return dp[ind][noOfTransaction] = Integer.max(buy, sell);
    }


    static int find2Tab(int prices[], int k) {

        //   int ind, int noOfTransaction, int[][]dp
        int[][] dp = new int[prices.length + 2][k * 2 + 2];


        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int noOfTransaction = 2 * k; noOfTransaction >= 0; noOfTransaction--) {

                int buy = 0;
                int sell = 0;
                if (noOfTransaction % 2 == 0) {
                    buy = Integer.max(-prices[ind] + dp[ind + 1][noOfTransaction + 1], dp[ind + 1][noOfTransaction]);
                } else {
                    sell = Integer.max(prices[ind] + dp[ind + 1][noOfTransaction + 1], dp[ind + 1][noOfTransaction]);
                }

                dp[ind][noOfTransaction] = Integer.max(buy, sell);
            }
        }

        return dp[0][0];
    }


    static int find2TabSO(int prices[], int k) {

        //   int ind, int noOfTransaction, int[][]dp
        // int[][] dp = new int[prices.length+2][k*2+2];

        int[] next = new int[k * 2 + 2];
        int[] curr = new int[k * 2 + 2];


        for (int ind = prices.length - 1; ind >= 0; ind--) {
            for (int noOfTransaction = 2 * k; noOfTransaction >= 0; noOfTransaction--) {

                int buy = 0;
                int sell = 0;
                if (noOfTransaction % 2 == 0) {
                    buy = Integer.max(-prices[ind] + next[noOfTransaction + 1], next[noOfTransaction]);
                } else {
                    sell = Integer.max(prices[ind] + next[noOfTransaction + 1], next[noOfTransaction]);
                }

                curr[noOfTransaction] = Integer.max(buy, sell);
            }
            next = curr.clone();
        }

        return next[0];
    }
}
