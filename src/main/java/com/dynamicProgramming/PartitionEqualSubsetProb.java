package com.dynamicProgramming;

public class PartitionEqualSubsetProb {

    public static void main(String[] args) {
        PartitionEqualSubsetProb obj = new PartitionEqualSubsetProb();
        int[] arr = {1, 5, 11, 5};
        System.out.println(obj.equalPartition(arr));
    }

    static boolean equalPartition(int arr[]) {
        // code here
        int sum = 0;
        for(int i : arr){
            sum = sum + i;
        }

        if(sum %2 == 1){
            return false;
        }else{

            //  return find(arr, 0, sum/2);

            //Boolean[][] dp = new Boolean[arr.length+1][sum+1];
            // return findMem(arr, 0, sum/2, dp);

            //return findTab(arr,sum/2);

            return findTabSO(arr,sum/2);
        }

    }

    static boolean find(int[] arr, int ind, int sum){
        if(sum == 0){
            return true;
        }
        if(ind >= arr.length){
            return false;
        }

        boolean inc = find(arr, ind+1, sum-arr[ind]);

        boolean exc = find(arr, ind+1, sum);

        return inc || exc;
    }

    static boolean findMem(int[] arr, int ind, int sum, Boolean[][] dp){
        if(sum == 0){
            return true;
        }
        if(ind >= arr.length){
            return false;
        }

        if(sum < 0){
            return false;
        }

        if( dp[ind][sum] != null){
            return dp[ind][sum];
        }

        boolean inc = findMem(arr, ind+1, sum-arr[ind], dp);

        boolean exc = findMem(arr, ind+1, sum, dp);


        return dp[ind][sum] = inc || exc;

    }


    static boolean findTab(int[] arr, int s){

        boolean[][] dp = new boolean[arr.length+1][s+1];

        for(int i=0;i<arr.length+1;i++){
            dp[i][0] = true;
        }

        for(int ind=arr.length-1;ind >=0;ind--){
            for(int sum = 0;sum <=s;sum++){
                boolean inc = false;
                if(sum - arr[ind] >=0)
                    inc = dp[ind+1][sum-arr[ind]];

                boolean exc = dp[ind+1][sum];


                dp[ind][sum] = inc || exc;
            }
        }

        return dp[0][s];

    }


    static boolean findTabSO(int[] arr, int s){

        boolean[] next = new boolean[s+1];
        boolean[] curr = new boolean[s+1];

        for(int i=0;i<arr.length+1;i++){
            next[0] = true;
        }

        for(int ind=arr.length-1;ind >=0;ind--){
            for(int sum = 0;sum <=s;sum++){
                boolean inc = false;
                if(sum - arr[ind] >=0)
                    inc = next[sum-arr[ind]];

                boolean exc = next[sum];
                curr[sum] = inc || exc;
            }
            next = curr.clone();
        }

        return next[s];

    }
}
