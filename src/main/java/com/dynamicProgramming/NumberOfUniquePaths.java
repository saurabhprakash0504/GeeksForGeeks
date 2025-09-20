package com.dynamicProgramming;

public class NumberOfUniquePaths {

    public static void main(String[] args) {
        int a = 3;
        int b = 2;

        System.out.println(NumberOfPath(a, b));
    }

    // Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) {
        // Your code here

        //  return find(a, b, 0, 0);

      /*  int[][] dp = new int[a][b];

        for(int i=0;i< a;i++){
            Arrays.fill(dp[i], -1);
        }

        return findMem(a, b, 0, 0, dp);*/

        // return findTab(a, b);

        return findTabSO(a, b);

    }

    static int find(int a, int b, int i, int j){
        if(i == a-1 && j == b-1){
            return 1;
        }

        if(i == a || j == b){
            return 0;
        }

        return find(a, b, i+1, j) + find(a, b, i, j+1);
    }

    static int findMem(int a, int b, int i, int j, int[][] dp){
        if(i == a-1 && j == b-1){
            return 1;
        }

        if(i == a || j == b){
            return 0;
        }

        if(dp [i][j] != -1){
            return dp[i][j];
        }

        return dp[i][j] = findMem(a, b, i+1, j, dp) + findMem(a, b, i, j+1, dp);
    }


    static int findTab(int a, int b){

        int[][] dp = new int[a][b];
        dp[a-1][b-1]= 1;

        for(int i= a-1;i>=0;i--){
            for(int j = b-1;j >=0;j--){

                if(i+1 < a && j+1 < b){
                    dp[i][j] =dp[i+1] [j] + dp[i] [j+1];
                }else if(i+1 < a){
                    dp[i][j] =dp[i+1] [j] ;
                }else if(j+1 < b){
                    dp[i][j] =dp[i] [j+1] ;
                }
            }
        }
        return dp[0][0];
    }


    static int findTabSO(int a, int b){


        int[] next = new int[b];
        int[] curr = new int[b];
        curr[b-1] = 1;

        for(int i= a-1;i>=0;i--){
            for(int j = b-1;j >=0;j--){

                if(i+1 < a && j+1 < b){
                    curr[j] =next [j] + curr [j+1];
                }else if(i+1 < a){
                    curr[j] =next [j] ;
                }else if(j+1 < b){
                    curr[j] =curr [j+1] ;
                }
            }
            next = curr.clone();
        }
        return next[0];
    }
}
