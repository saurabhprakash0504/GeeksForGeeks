package com.dynamicProgramming;

import java.util.Arrays;

public class MaximumRopeCuts {

    public static void main(String[] args) {
        System.out.println(maximizeCuts(7, 1, 7, 2));
    }

    public static int maximizeCuts(int n, int x, int y, int z) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);

        int val =  maxTab(n,x,y,z);

        if(val < 0){
            val = 0;
        }

        return val;

    }


    public static int maxMem(int n, int x, int y, int z, int[] arr) {
        // Your code here
        if(n == 0){
            return 0;
        }

        if(n < 0){
            return Integer.MIN_VALUE;
        }

        if(arr[n]!=-1){
            return arr[n];
        }

        return arr[n] = 1+ Integer.max(maxMem(n-x,x,y,z, arr), Integer.max(maxMem(n-y,x,y,z,arr), maxMem(n-z,x,y,z, arr)));
    }


    public static int maxTab(int n, int x, int y, int z) {
        // Your code here
        int[] arr =new int[n+1];
        Arrays.fill(arr,Integer.MIN_VALUE);
        arr[0] = 0;
        for(int i=1;i<=n;i++){

            int a = i-x;
            int b = i-y;
            int c = i-z;

            if(a >=0 )
                arr[i] = Integer.max(arr[i],arr[a]+1);
            if(b >=0 )
                arr[i] = Integer.max(arr[i],arr[b]+1);
            if(c >=0 )
                arr[i] =Integer.max(arr[i],arr[c]+1);

        }

        return arr[n];
    }
}
