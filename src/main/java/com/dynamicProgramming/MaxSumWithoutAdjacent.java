package com.dynamicProgramming;

import java.util.Arrays;

public class MaxSumWithoutAdjacent {

    public static void main(String[] args) {
        int[] arr = {9,9,8,2};
        System.out.println(findMaxSum(arr));
    }

    static int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;

        int[] mat = new int[n + 1];

        Arrays.fill(mat, -1);

        //  return findMem(0, n-1, arr, mat);

        //   return findTab(n, arr, mat);

        return findTabMemory(n, arr);

    }

    static int findMem(int curr, int len, int[] arr, int[] mat) {

        if (curr > len) {
            return 0;
        }

        if (mat[curr] != -1) {
            return mat[curr];
        }

        int include = arr[curr] + findMem(curr + 2, len, arr, mat);

        int exclude = findMem(curr + 1, len, arr, mat);

        return mat[curr] = Integer.max(include, exclude);
    }


    static int findTab(int len, int[] arr, int[] mat) {

        mat[0] = 0;
        mat[1] = arr[0];

        for (int i = 2; i <= len; i++) {
            int include = arr[i - 1] + mat[i - 2];

            int exclude = mat[i - 1];

            mat[i] = Integer.max(include, exclude);
        }


        return mat[len];
    }


    static int findTabMemory(int len, int[] arr) {

        int prev_prev = 0;
        int prev = arr[0];

        int max = Integer.max(prev_prev, prev);

        for (int i = 1; i < len; i++) {
            int include = arr[i] + prev_prev;

            int exclude = prev;


            max = Integer.max(include, exclude);

            prev_prev = prev;
            prev = max;

        }


        return max;
    }
}
