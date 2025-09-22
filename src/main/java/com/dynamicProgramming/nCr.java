package com.dynamicProgramming;

public class nCr {

    public static void main(String[] args) {

        int n = 5;
        int r = 2;

        System.out.println(nCrModp(n, r));
    }

    // Function to return nCr mod 10^9+7 for given n and r.
    public static int nCrModp(int n, int r) {
        // your code here
        //  return find(n, r);
      /*  int[][] dp = new int[n+1][r+1];
        for(int i=0;i< n+1;i++){
            Arrays.fill(dp[i], -1);
        }
        return findMem(n, r, dp) ;*/

        //return findTab(n, r);
        return findTabSO(n,r);
    }

    static int find(int n, int r){


        if(n < r){
            return 0;
        }

        if(r ==0){
            return 1;
        }

        if(n == r){
            return 1;
        }

        int inc =  find(n-1, r);
        int exc = find(n-1, r-1);

        return inc + exc;

    }

    static int findMem(int n, int r, int[][] dp){



        if(n < r){
            return 0;
        }

        if(r ==0){
            return 1;
        }

        if(n == r){
            return 1;
        }

        if(dp[n][r] != -1){
            return dp[n][r];
        }

        int inc =  findMem(n-1, r, dp) ;
        int exc = findMem(n-1, r-1, dp) ;
        int mod = 1000000007;
        return dp[n][r] = (inc + exc)% mod ;

    }



    static int findTab(int n, int r){

        int[][] dp = new int[n+1][r+1];


        for(int i=0;i<n+1;i++){
            dp[i][0] = 1;
        }

        dp[n][r]= 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=r;j++){
                int inc =  dp[i-1] [j];
                int exc = dp[i-1] [j-1];
                int mod = 1000000007;
                dp[i][j] = (inc + exc)% mod ;
            }
        }

        return dp[n][r];


    }


    static int findTabSO(int n, int r){

        int[] prev = new int[r+1];
        int[] curr = new int[r+1];

        prev[0] =1;
        curr[0] =1;
        curr[r]= 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=r;j++){
                int inc = prev [j];
                int exc = prev[j-1];
                int mod = 1000000007;
                curr[j] = (inc + exc)% mod ;
            }
            prev = curr.clone();
        }

        return prev[r];


    }
}
