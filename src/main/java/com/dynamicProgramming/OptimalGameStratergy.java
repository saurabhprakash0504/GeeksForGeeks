package com.dynamicProgramming;

public class OptimalGameStratergy {

    public static void main(String[] args) {

        OptimalGameStratergy obj = new OptimalGameStratergy();
        int arr[] = {20, 30, 2, 2, 2, 10};
        System.out.println(obj.maximumAmount(arr));
    }

    public int maximumAmount(int arr[]) {
        // code here

        // return  find(arr, 0, arr.length-1);


  /*  int n = arr.length;
    int[][] dp = new int[n+1][n+1];
    for(int i=0;i< n+1;i++){
        Arrays.fill(dp[i], -1);
    }

    return findMem(arr, 0, arr.length-1, dp);*/

        //  return findTab(arr);

        return findTabSO(arr);

    }

    int find(int[] arr, int start, int end) {
        if (start > end) {
            return 0;
        }

        int incStart = arr[start] + Integer.min(find(arr, start + 2, end), find(arr, start + 1, end - 1));

        int incEnd = arr[end] + Integer.min(find(arr, start + 1, end - 1), find(arr, start, end - 2));

        return Integer.max(incStart, incEnd);
    }

    int findMem(int[] arr, int start, int end, int[][] dp) {
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int incStart = arr[start] + Integer.min(findMem(arr, start + 2, end, dp), findMem(arr, start + 1, end - 1, dp));

        int incEnd = arr[end] + Integer.min(findMem(arr, start + 1, end - 1, dp), findMem(arr, start, end - 2, dp));

        return dp[start][end] = Integer.max(incStart, incEnd);
    }


    int findTab(int[] arr) {

        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int start = n - 1; start >= 0; start--) {

            for (int end = start; end < n; end++) {

                int incStart = 0;
                int incEnd = 0;


                int a = 0;
                int b = 0;
                if (start + 2 < n) {
                    a = dp[start + 2][end];
                }
                if (start + 1 < n && end - 1 >= 0) {
                    b = dp[start + 1][end - 1];
                }

                incStart = arr[start] + Integer.min(a, b);
                // incStart = arr[start] + Integer.min(dp[start+2] [end], dp[start+1] [end-1]);

                // if( start+1 < n && end-1 >=0 && end-2 >= 0)

                int b1 = 0;
                int a1 = 0;
                if (start + 1 < n && end - 1 >= 0) {
                    b1 = dp[start + 1][end - 1];
                }
                if (end - 2 >= 0) {
                    a1 = dp[start][end - 2];
                }

                incEnd = arr[end] + Integer.min(b1, a1);

                dp[start][end] = Integer.max(incStart, incEnd);

            }

        }

        return dp[0][n - 1];

    }


    int findTabSO(int[] arr) {

        int n = arr.length;

        int[] next2 = new int[n + 1];
        int[] next1 = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int start = n - 1; start >= 0; start--) {

            for (int end = start; end < n; end++) {

                int incStart = 0;
                int incEnd = 0;


                int a = 0;
                int b = 0;
                if (start + 2 < n) {
                    a = next2[end];
                }
                if (start + 1 < n && end - 1 >= 0) {
                    b = next1[end - 1];
                }

                incStart = arr[start] + Integer.min(a, b);

                int b1 = 0;
                int a1 = 0;
                if (start + 1 < n && end - 1 >= 0) {
                    b1 = next1[end - 1];
                }
                if (end - 2 >= 0) {
                    a1 = curr[end - 2];
                }

                incEnd = arr[end] + Integer.min(b1, a1);

                curr[end] = Integer.max(incStart, incEnd);

            }
            next2 = next1.clone();
            next1 = curr.clone();

        }

        return next1[n - 1];

    }
}
