package com.dynamicProgramming;

import java.util.Arrays;

public class DisArrangementOfBalls {

    public static void main(String[] args) {
        System.out.println(countDer(5));
    }


    static int countDer(int n) {
        // Base case
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);

        //return countDerMem(n, arr);

        //   return countDerTab(n);

        return countDerTabSpaceOpt(n);
    }

    static int countDerMem(int n, int[] arr) {
        // Base case
        if(n == 1){
            return 0;
        }

        if(n ==2){
            return 1;
        }

        if(arr[n]!=-1){
            return arr[n];
        }

        return arr[n] = (n-1) *  (countDerMem(n-2, arr)+countDerMem(n-1, arr));
    }


    static int countDerTab(int n) {
        int[] arr = new int[n+1];

        Arrays.fill(arr,-1);
        arr[1] = 0;
        if(n==1){
            return 0;
        }
        arr[2] = 1;

        for(int i=3;i<=n;i++){
            arr[i] = (i-1) * (arr[i-2]+arr[i-1]);
        }

        return arr[n];

        // return arr[n] = (n-1) *  (countDerMem(n-2, arr)+countDerMem(n-1, arr));
    }

    static int countDerTabSpaceOpt(int n) {
        //  int[] arr = new int[n+1];

        //  Arrays.fill(arr,-1);
        int prev2 = 0;
        if(n==1){
            return 0;
        }
        int prev1 = 1;

        for(int i=3;i<=n;i++){


            int temp = (i-1) * (prev2 + prev1);

            prev2 = prev1;
            prev1 = temp;

        }

        return prev1;


    }
}
