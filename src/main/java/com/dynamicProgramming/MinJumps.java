package com.dynamicProgramming;

public class MinJumps {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int len = arr.length;
        minimumJumps(arr, len);
    }

    public static int minimumJumps(int arr[], int n) {
        // your code here
        //mini = Integer.MAX_VALUE;
        // return  find(arr, n, 0);
        //  return mini;
      /*  int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int val = findMem(arr, n, 0, dp);

       if(val == Integer.MAX_VALUE){
           return -1;
       }

       return val;*/

        return findMin(arr, n);
    }

    // static int mini = Integer.MAX_VALUE;
    static int find(int[] arr, int len, int start){

        if(start >= len-1){
            return 0;
        }

        if(arr[start] == 0){
            return Integer.MAX_VALUE;
        }

        int mini = Integer.MAX_VALUE;
        for(int i=1;i <= arr[start] && i+start < len;i++){
            int jump = find(arr, len, start+i);
            if(jump != Integer.MAX_VALUE){
                mini = Integer.min(1+ jump, mini);
            }

            // find(arr, len, start-i);
        }

        return mini;
    }


    static int findMem(int[] arr, int len, int start, int[] dp){

        if(start >= len-1){
            return 0;
        }


        if(dp[start] != -1){
            return dp[start];
        }

        if(arr[start] == 0){
            return dp[start]= Integer.MAX_VALUE;
        }


        int mini = Integer.MAX_VALUE;
        for(int i=1;i <= arr[start] && i+start < len;i++){
            int jump = findMem(arr, len, start+i, dp);
            if(jump != Integer.MAX_VALUE){
                mini = Integer.min(1+ jump, mini);
                if(mini ==1){
                    break;
                }
            }

            // find(arr, len, start-i);
        }

        return dp[start]= mini;
    }


    static int findMin(int[] arr, int n){
        if(n ==0 || arr[0] == 0){
            return -1;
        }
        int jumps = 0;
        int l=0;
        int r =0;
        while(r < n-1){
            int far = 0;
            for(int i=l;i<=r;i++){
                far = Integer.max(i+arr[i], far);
            }
            if(far <=r){
                return -1;
            }
            l= r+1;
            r = far;
            jumps++;
        }
        return jumps;
    }
}
