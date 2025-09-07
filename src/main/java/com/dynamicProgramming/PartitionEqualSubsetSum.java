package com.dynamicProgramming;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int arr[] = {1,5,11,5};
        System.out.println(equalPartition(arr));
    }

    static boolean equalPartition(int arr[]) {
        // code here
        int sum =0;
        for(int a : arr){
            sum = sum +a;
        }

       /* if(sum %2 == 0){

            return find(arr, sum/2, 0);

        }else{
            return false;
        }*/


        if(sum %2 == 0){

            Boolean[][] dp = new Boolean[(sum/2) +1][arr.length+1];


            //  return findMem(arr, sum/2, 0, dp);

            return findTab(arr, sum);

            //  return findTabSO(arr, sum);


        }else{
            return false;
        }




    }


    static boolean find(int[] arr, int tar, int ind ){

        if(tar ==0){
            return true;
        }

        if(tar <0 || ind >= arr.length){
            return false;
        }

        boolean inc = find(arr, tar-arr[ind], ind+1);
        boolean exc = find(arr, tar, ind+1);

        return inc || exc ;

    }


    static boolean findMem(int[] arr, int tar, int ind, Boolean[][] dp ){

        if(tar ==0){
            return true;
        }

        if(tar <0 || ind >= arr.length){
            return false;
        }

        if(dp[tar][ind] != null){
            return dp[tar][ind];
        }

        boolean inc = findMem(arr, tar-arr[ind], ind+1, dp);
        boolean exc = findMem(arr, tar, ind+1, dp);

        return dp[tar][ind] = inc || exc ;

    }


    static boolean findTab(int[] arr, int sum){
        if(sum ==0 ){
            return true;
        }


        if(sum %2 == 0){
            int tar1 = sum/2;
            boolean[][] dp = new boolean[arr.length+1][tar1 +1];

            for(int i=0;i< arr.length +1 ;i++){
                dp[i][0]= true;
            }

            for(int ind = arr.length-1;ind>=0;ind--){
                for(int tar=1;tar<= tar1 ;tar++){

                    Boolean inc =false ;
                    if(tar-arr[ind] >=0)
                        inc = dp [ind+1][tar-arr[ind]];
                    Boolean exc = dp[ind+1][tar];

                    dp[ind][tar] = inc || exc ;
                }
            }

            return dp[0][tar1];


        }else{
            return false;
        }
    }


    static boolean findTabSO(int[] arr, int sum){
        if(sum ==0 ){
            return true;
        }


        if(sum %2 == 0){
            int tar1 = sum/2;
            //boolean[][] dp = new boolean[arr.length+1][tar1 +1];
            boolean[] next = new boolean[tar1+1];
            boolean[] curr = new boolean[tar1+1];

            for(int i=0;i< tar1+1 ;i++){
                curr[0]= true;
            }

            for(int ind = arr.length-1;ind>=0;ind--){
                for(int tar=1;tar<= tar1 ;tar++){

                    Boolean inc =false ;
                    if(tar-arr[ind] >=0)
                        inc = next[tar-arr[ind]];
                    Boolean exc = next[tar];

                    curr[tar] = inc || exc ;
                }
                for(int i=0;i< tar1+1;i++){
                    next[i]= curr[i];
                }
                // next = curr.clone();
            }

            return next[tar1];


        }else{
            return false;
        }
    }
}
