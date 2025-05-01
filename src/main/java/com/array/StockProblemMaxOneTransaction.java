package com.array;

public class StockProblemMaxOneTransaction {

    public static void main(String[] args) {
          int[] arr = {1, 3, 6, 9, 11};
     //   int[] arr = {7, 1, 5, 3, 6, 4};

        System.out.println(maximumProfit(arr));
    }

    static public int maximumProfit(int prices[]) {
        int currTotal = 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (min < prices[i]) {
                currTotal = prices[i] - min;
            } else {
                min = prices[i];

            }
            max = Integer.max(max, currTotal);
        }
        return max;
    }
}
