package com.dynamicProgramming;

import java.util.Arrays;

public class MinScoreTriangulationOfPolygon {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(minScoreTriangulation(arr));
    }

    public static int minScoreTriangulation(int[] values) {
        int len = values.length-1;
        int[][] dp = new int[len+1][len+1];
        for(int i=0;i<=len;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(values, 0, len, dp);
        //  return mini;
    }

    static int mini =Integer.MAX_VALUE;
    static int find(int[] val, int start, int end, int[][] dp ){
        if(start+1 == end){
            return 0;
            //return;
        }
        if(dp[start][end]!=-1){
            return dp[start][end];
        }

        for(int k =start+1;k<end;k++){
            mini = Integer.min(mini, val[start]*val[end]*val[k]+find(val,start,k, dp)+find(val,k,end, dp));
            dp[start][end]= mini;
        }

        return mini;
    }
}
