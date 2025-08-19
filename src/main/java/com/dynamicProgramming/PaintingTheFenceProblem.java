package com.dynamicProgramming;

import java.util.Arrays;

public class PaintingTheFenceProblem {


    int countWays(int n, int k) {

        int[] arr = new int[n+1];
        Arrays.fill(arr,-1);

        //  return countWaysMem(n,k, arr);

        //  return countWaysTab(n,k);

        return countWaysSpace(n,k);

    }


    int countWaysRec(int n, int k) {
        // code here.

        if(n ==1){
            return k;
        }

        if(n == 2){
            return (k + (k *(k-1)));
        }

        return ((countWays(n-2, k) * (k-1)) + (countWays(n-1, k) * (k-1)));
    }


    int countWaysMem(int n, int k, int[] arr ) {
        // code here.

        if(n ==1){
            return k;
        }

        if(n == 2){
            return (k + (k *(k-1)));
        }

        if(arr[n]!=-1){
            return arr[n];
        }

        return arr[n] = ((countWaysMem(n-2, k, arr) * (k-1)) + (countWaysMem(n-1, k, arr) * (k-1)));
    }


    int countWaysTab(int n, int k ) {
        // code here.

        int[] arr = new int[n+1];

        arr[1] = k;
        if(n ==1){
            return arr[n];
        }
        arr[2] = (k + (k *(k-1)));

        for(int i=3;i<=n;i++){
            arr[i]= (arr[i-2] * (k-1))+ (arr[i-1] * (k-1));
        }
        // return arr[n] = ((countWaysMem(n-2, k, arr) * (k-1)) + (countWaysMem(n-1, k, arr) * (k-1)));

        return arr[n];
    }


    int countWaysSpace(int n, int k ) {
        // code here.

        // int[] arr = new int[n+1];

        int prev2 = k;
        if(n ==1){
            return prev2;
        }
        int prev1  = (k + (k *(k-1)));

        for(int i=3;i<=n;i++){
            int temp = (prev2 * (k-1))+ (prev1 * (k-1));
            prev2 = prev1;
            prev1 = temp;
        }
        // return arr[n] = ((countWaysMem(n-2, k, arr) * (k-1)) + (countWaysMem(n-1, k, arr) * (k-1)));

        return prev1;
    }
}
