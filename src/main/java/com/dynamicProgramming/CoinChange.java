package com.dynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        int coins[] = {1, 2, 3};
        int val = 5;
        int numberOfCoins = coins.length;

        CoinChange obj = new CoinChange();
        System.out.println(obj.minimumNumberOfCoins(coins, numberOfCoins, val));
    }

    public long minimumNumberOfCoins(int coins[], int len, int value) {
        // your code here
        //Long res = find(0, value, coins, len);

        /*long[][] dp = new long[len+1][value+1];
        for(int i=0;i<=len;i++){
            Arrays.fill(dp[i], -1);
        }

        Long res = findMem(0, value, coins, len, dp);*/
        //Long res = findTab(value, coins, len);
        Long res = findTabSO(value, coins, len);

        // System.out.println("res >> "+ res);
        if(res == Long.MAX_VALUE){
            return -1L;
        }else{
            return res;
        }
    }

    long find(int ind, int val, int[] coins, int len){

        if(val == 0){
            return 0L;
        }

        if(ind == len){
            return Long.MAX_VALUE;
        }



        if(val < 0){
            return Long.MAX_VALUE;
        }

        Long inc = Long.MAX_VALUE;
        if(val >= coins[ind]){
            long res = find(ind, val-coins[ind], coins, len);
            if(res != Long.MAX_VALUE){
                inc = res +1;
            }
        }
        Long exc = find(ind+1, val, coins, len);

        return Long.min(inc, exc);

    }



    long findMem(int ind, int val, int[] coins, int len, long[][] dp){

        if(val == 0){
            return 0L;
        }

        if(ind == len){
            return Long.MAX_VALUE;
        }



        if(val < 0){
            return Long.MAX_VALUE;
        }

        if(dp[ind][val] != -1){
            return dp[ind][val];
        }

        Long inc = Long.MAX_VALUE;
        if(val >= coins[ind]){
            long res = findMem(ind, val-coins[ind], coins, len, dp);
            if(res != Long.MAX_VALUE){
                inc = res +1;
            }
        }
        Long exc = findMem(ind+1, val, coins, len, dp);

        return dp[ind][val]=Long.min(inc, exc);

    }



    long findTab( int value, int[] coins, int len){

        long[][] dp = new long[len+1][value+1];

        for(int i=0;i<value+1;i++){
            dp[len][i]=Long.MAX_VALUE;
        }

        for(int ind= len-1;ind>=0;ind--){

            for(int val=1;val<= value;val++){


                Long inc = Long.MAX_VALUE;
                if(val >= coins[ind]){
                    long res = dp[ind] [val-coins[ind]];
                    if(res != Long.MAX_VALUE){
                        inc = res +1;
                    }
                }
                Long exc = dp[ind+1] [val];

                dp[ind][val]=Long.min(inc, exc);

            }

        }

        return dp[0][value];
    }


    long findTabSO( int value, int[] coins, int len){

        //  long[][] dp = new long[len+1][value+1];

        long[] next = new long[value+1];
        long[] curr = new long[value+1];

        Arrays.fill(next,Long.MAX_VALUE );
        /*for(int i=0;i<value+1;i++){
            next[i]=Long.MAX_VALUE;
        }*/

        for(int ind= len-1;ind>=0;ind--){

            for(int val=1;val<= value;val++){


                Long inc = Long.MAX_VALUE;
                if(val >= coins[ind]){
                    long res =curr [val-coins[ind]];
                    if(res != Long.MAX_VALUE){
                        inc = res +1;
                    }
                }
                Long exc = next [val];

                curr[val]=Long.min(inc, exc);

            }
            next = curr.clone();

        }

        return next[value];
    }
}
