package com.dynamicProgramming;

public class BuyAndSell5MultipleTransactionWithFees {

    public static void main(String[] args) {
        BuyAndSell5MultipleTransactionWithFees obj = new BuyAndSell5MultipleTransactionWithFees();
        int[] arr = {1, 3, 2, 8, 4, 9};
        int k = 2;
        System.out.println(obj.maxProfit(arr, k));
    }

    public int maxProfit(int arr[], int k) {
        // Code here
        // return find(arr, k, 0, 1);

      /*  int[][] dp = new int[arr.length+1][2];
        for(int i=0;i< arr.length+1;i++){
            Arrays.fill(dp[i], -1);
        }

        return findMem(arr, k, 0, 1, dp);*/

        //return findTab(arr,k);

        return findTabSO(arr, k);
    }

    int find(int[] arr, int k, int ind, int isBuy) {
        if (ind >= arr.length) {
            return 0;
        }

        //int profit=0;
        int buy = 0;
        int sell = 0;

        if (isBuy == 1) {
            buy = Integer.max(-arr[ind] + find(arr, k, ind + 1, 0), find(arr, k, ind + 1, 1));
        } else {
            sell = Integer.max(arr[ind] + (-k) + find(arr, k, ind + 1, 1), find(arr, k, ind + 1, 0));
        }

        return Integer.max(buy, sell);
    }


    int findMem(int[] arr, int k, int ind, int isBuy, int[][] dp) {
        if (ind >= arr.length) {
            return 0;
        }

        //int profit=0;
        int buy = 0;
        int sell = 0;

        if (dp[ind][isBuy] != -1) {
            return dp[ind][isBuy];
        }

        if (isBuy == 1) {
            buy = Integer.max(-arr[ind] + findMem(arr, k, ind + 1, 0, dp), findMem(arr, k, ind + 1, 1, dp));
        } else {
            sell = Integer.max(arr[ind] + (-k) + findMem(arr, k, ind + 1, 1, dp), findMem(arr, k, ind + 1, 0, dp));
        }

        return dp[ind][isBuy] = Integer.max(buy, sell);
    }


    int findTab(int[] arr, int k) {

        int[][] dp = new int[arr.length + 1][2];

        for (int ind = arr.length - 1; ind >= 0; ind--) {
            for (int isBuy = 0; isBuy <= 1; isBuy++) {
                int buy = 0;
                int sell = 0;
                if (isBuy == 1) {
                    buy = Integer.max(-arr[ind] + dp[ind + 1][0], dp[ind + 1][1]);
                } else {
                    sell = Integer.max(arr[ind] + (-k) + dp[ind + 1][1], dp[ind + 1][0]);
                }

                dp[ind][isBuy] = Integer.max(buy, sell);
            }
        }

        return dp[0][1];


    }


    int findTabSO(int[] arr, int k) {

        int[] next = new int[2];
        int[] curr = new int[2];

        for (int ind = arr.length - 1; ind >= 0; ind--) {
            for (int isBuy = 0; isBuy <= 1; isBuy++) {
                int buy = 0;
                int sell = 0;
                if (isBuy == 1) {
                    buy = Integer.max(-arr[ind] + next[0], next[1]);
                } else {
                    sell = Integer.max(arr[ind] + (-k) + next[1], next[0]);
                }

                curr[isBuy] = Integer.max(buy, sell);
            }
            next = curr.clone();
        }

        return next[1];

    }
}
