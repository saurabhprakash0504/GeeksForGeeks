package com.dynamicProgramming;

import java.util.Arrays;

public class CuttingRodProblem {

    public static void main(String[] args) {
        int n = 5, x = 2, y = 5, z = 1;

        CuttingRodProblem obj = new CuttingRodProblem();

        System.out.println(obj.maximizeCuts(n, x, y, z));
    }

    // Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z) {
        // Your code here
        // return find(n, x, y, z);
       /* int[] dp= new int[n+1];
        Arrays.fill(dp, -1);
        int ans = findMem(n, x, y , z, dp);
        if( ans < 0){
            return 0;
        }else{
            return ans;
        }*/
        return findTab(n,x,y,z);
    }

    int find(int n, int x, int y, int z){
        if(n<0){
            return Integer.MIN_VALUE;
        }

        if(n == 0){
            return 0;
        }


        int a = 1+ find(n-x, x,y,z);
        int b =  1+find(n-y, x,y, z);
        int c =  1+ find(n-z, x, y, z);

        return Integer.max(a, Integer.max(b, c));
    }




    int findMem(int n, int x, int y, int z,  int[] dp){
        if(n<0){
            return Integer.MIN_VALUE;
            //return -1;
        }

        if(n == 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }


        int a = 1+findMem(n-x, x,y,z, dp);
        int b =  1+ findMem(n-y, x,y, z ,dp);
        int c =  1 +findMem(n-z, x, y, z, dp);

        // return dp[n] = a +b+c;

        return dp[n] =  Integer.max(a, Integer.max(b, c));
    }



    int findTab(int n, int x, int y, int z){

        int[] dp =  new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        dp[0] = 0;

        for(int i=1;i<=n;i++){
            int a = Integer.MIN_VALUE;
            int b = Integer.MIN_VALUE;
            int c = Integer.MIN_VALUE;
            //  int a =0;
            //int b =0;
            //int c= 0;
            if(i-x >=0 )
                a = 1+ dp[i-x];
            if(i-y >=0 )
                b =  1+ dp[i-y];
            if(i-z >=0 )
                c =  1 + dp[i-z];

            dp[i] =  Integer.max(a, Integer.max(b, c));
        }

        if(dp[n] < 0){
            return 0;
        }else{
            return dp[n];
        }

    }
}
