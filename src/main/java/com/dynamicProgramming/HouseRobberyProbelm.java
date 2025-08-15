package com.dynamicProgramming;

import java.util.Arrays;

public class HouseRobberyProbelm {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};

        System.out.println(maxValue(arr));
    }


    public static int maxValue(int arr[]) {
        // code here
        int n = arr.length;



        int[] first = new int[n-1];
        int[] sec = new int[n-1];

        int[] mat = new int[n];
        int[] mat1 = new int[n];

        Arrays.fill(mat,-1);
        Arrays.fill(mat1,-1);

        for(int i=0;i<n-1;i++){

            first[i] = arr[i];

        }

        for(int i=1;i<n;i++){

            sec[i-1] = arr[i];

        }

        return Integer.max(find(0, n-1, first, mat), find(0,n-1, sec, mat1));
    }

    static int find(int ind , int len, int[] arr, int[] mat){

        if(ind >= len){
            return 0;
        }

        if(mat[ind] != -1){
            return mat[ind];
        }

        int inc = arr[ind] + find(ind+2, len, arr, mat);

        int exc = find(ind+1, len, arr, mat);

        return mat[ind] = Integer.max(inc, exc);

    }
}
