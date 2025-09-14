package com.dynamicProgramming;

public class BuyAndSell1SingleTransaction {

    public static void main(String[] args) {

        BuyAndSell1SingleTransaction obj = new BuyAndSell1SingleTransaction();
        int[] arr = {7,1,5,3,6,4};
        System.out.println(obj.maximumProfit(arr));
    }

    public int maximumProfit(int prices[]) {
        // Code here
        int len = prices.length;
        int buy = prices[0];
        int profit = 0;
        for(int i=1;i<len;i++){
            int diff = prices[i] - buy;
            profit = Integer.max(profit, diff);
            buy = Integer.min(buy, prices[i]);
        }
        return profit;
    }
}
