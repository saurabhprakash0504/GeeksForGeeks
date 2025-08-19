package com.dynamicProgramming;

import java.util.Arrays;

public class KnapsackProbDP {

    public static void main(String[] args) {
        int W = 4, val[] = {1, 2, 3}, wt[] = {4, 5, 1};
        System.out.println(knapsack(W, val, wt));
    }

    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int[][] arr = new int[val.length+1][W+1];
        for(int i=0;i<=val.length;i++){
            Arrays.fill(arr[i],-1);
        }
        // return findMaxMem(W, val, wt, wt.length-1, arr);

        //return findMaxTab(W, val, wt);
        return findMaxTabSpace(W,val,wt);

        // return findMaxTabSpace2(W,val,wt);
    }

    static int findMaxMem(int w, int[] val, int[] wt, int ind, int[][] arr){

       /* if(ind < 0){
            return 0;
        }

        if(w <= 0){
            return 0;
        }*/

        if(ind ==0){
            if(wt[0] <= w){
                return val[0];
            }else{
                return 0;
            }
        }

        if(arr[ind][w] !=-1){
            return arr[ind][w];
        }

        int inc =0;
        if(w >= wt[ind]){
            inc = val[ind]+ findMaxMem(w-wt[ind], val, wt, ind-1, arr);
        }

        int exc = findMaxMem(w, val, wt, ind-1, arr);



        return arr[ind][w]= Integer.max(inc, exc);
    }


    static int findMaxTab(int w, int[] val, int[] wt){

        int ind = val.length;
        int[][] arr = new int[ind][w+1];

        for(int i=0;i<=w;i++){
            if(wt[0] <=i){
                arr[0][i]= val[0];
            }else{
                arr[0][i]=0;
            }
        }



        for(int i=1;i<ind;i++){
            for(int j=0;j<w+1;j++){
                int inc =0;
                if(j >= wt[i]){
                    inc = val[i]+ arr[i-1][j - wt[i]];
                }

                int exc = arr [i-1][j];

                arr[i][j]= Integer.max(inc,exc);
            }
        }

        return arr[ind-1][w] ;
    }


    static int findMaxTabSpace(int w, int[] val, int[] wt){

        int ind = val.length;


        int[] prev2 = new int[w+1];
        int[] prev1 = new int[w+1];

        for(int i=0;i<=w;i++){
            if(wt[0] <=i){
                prev2[i]= val[0];
            }else{
                prev2[i]=0;
            }
        }



        for(int i=1;i<ind;i++){
            for(int j=0;j<w+1;j++){
                int inc =0;
                if(j >= wt[i]){
                    inc = val[i]+ prev2[j - wt[i]];
                }

                int exc = prev2[j];

                prev1[j]= Integer.max(inc,exc);
            }
            prev2 = prev1.clone();
        }

        return prev2[w] ;
    }


    static int findMaxTabSpace2(int w, int[] val, int[] wt){

        int ind = val.length;


        int[] prev2 = new int[w+1];
        //   int[] prev1 = new int[w+1];

        for(int i=0;i<=w;i++){
            if(wt[0] <=i){
                prev2[i]= val[0];
            }else{
                prev2[i]=0;
            }
        }



        for(int i=1;i<ind;i++){
            for(int j=w;j>=0;j--){
                int inc =0;
                if(j >= wt[i]){
                    inc = val[i]+ prev2[j - wt[i]];
                }

                int exc = prev2[j];

                prev2[j]= Integer.max(inc,exc);
            }
            // prev2 = prev1.clone();
        }

        return prev2[w] ;
    }
}
