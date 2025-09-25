package com.dynamicProgramming;

public class EggDroppingProblem {

    public static void main(String[] args) {

        int n = 2, k = 10;
        System.out.println(eggDrop(n, k));
    }


    // Function to find minimum number of attempts needed in
    // order to find the critical floor.
    static int eggDrop(int n, int k) {
        // return find(n, k);
        // return findBinarySearch(n,k);
       /* int[][] dp = new int[n+1][k+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i], -1);
        }

        return findMem(n, k, dp);*/

       /* int[][] dp = new int[n+1][k+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i], -1);
        }

        return findBinarySearchMem(n, k, dp);*/

        //  return findBinarySearchTab(n, k);

        return findBinarySearchTabSO(n, k);


    }

    static int find(int noEggs, int noFloor){
        if(noEggs == 0){
            return 0;
        }

        if(noFloor == 0 || noFloor == 1){
            return noFloor;
        }

        if(noEggs == 1){
            return noFloor;
        }

        int minAttempt = Integer.MAX_VALUE;
        for(int i=1;i<=noFloor;i++){
            int breaking = find(noEggs-1, i-1);
            int notBreaking = find(noEggs, noFloor-i);
            int temp = 1 + Integer.max(breaking, notBreaking);
            minAttempt = Integer.min(minAttempt, temp);
        }

        return minAttempt;

    }


    static int findBinarySearch(int noEggs, int noFloor){
        if(noEggs == 0){
            return 0;
        }

        if(noFloor == 0 || noFloor == 1){
            return noFloor;
        }

        if(noEggs == 1){
            return noFloor;
        }

        int minAttempt = Integer.MAX_VALUE;
        int low = 1 ;
        int high = noFloor;
        while(low <= high){
            int mid = (high + low )/2;
            int breaking = findBinarySearch(noEggs-1, mid-1);
            int notBreaking = findBinarySearch(noEggs,  noFloor - mid );
            int temp = 1 + Integer.max(breaking, notBreaking);
            minAttempt = Integer.min(minAttempt, temp);

            if(breaking < notBreaking){
                low = mid +1;
            }else{
                high = mid - 1;
            }
        }

        return minAttempt;

    }


    static int findMem(int noEggs, int noFloor, int[][] dp){
        if(noEggs == 0){
            return 0;
        }

        if(noFloor == 0 || noFloor == 1){
            return noFloor;
        }

        if(noEggs == 1){
            return noFloor;
        }

        if(dp[noEggs][noFloor] !=-1){
            return dp[noEggs][noFloor];
        }

        int minAttempt = Integer.MAX_VALUE;
        for(int i=1;i<=noFloor;i++){
            int breaking = findMem(noEggs-1, i-1, dp);
            int notBreaking = findMem(noEggs, noFloor-i, dp);
            int temp = 1 + Integer.max(breaking, notBreaking);
            minAttempt = Integer.min(minAttempt, temp);
        }

        return dp[noEggs][noFloor] = minAttempt;

    }


    static int findBinarySearchMem(int noEggs, int noFloor, int[][] dp){
        if(noEggs == 0){
            return 0;
        }

        if(noFloor == 0 || noFloor == 1){
            return noFloor;
        }

        if(noEggs == 1){
            return noFloor;
        }

        if(dp[noEggs][noFloor] != -1){
            return dp[noEggs][noFloor];
        }

        int minAttempt = Integer.MAX_VALUE;
        int low = 1 ;
        int high = noFloor;
        while(low <= high){
            int mid = (high + low )/2;
            int breaking = findBinarySearchMem(noEggs-1, mid-1, dp);
            int notBreaking = findBinarySearchMem(noEggs,  noFloor - mid, dp );
            int temp = 1 + Integer.max(breaking, notBreaking);
            minAttempt = Integer.min(minAttempt, temp);

            if(breaking < notBreaking){
                low = mid +1;
            }else{
                high = mid - 1;
            }
        }

        return dp[noEggs][noFloor] = minAttempt;

    }


    static int findBinarySearchTab(int e, int f){

        int[][] dp = new int[e+1][f+1];

        for(int i=0 ; i<e+1;i++){
            dp[i][1] = 1;
        }

        for(int j=0;j<f+1;j++){
            dp[1][j] = j;
        }

        for(int noEggs = 2;noEggs <=e; noEggs++){
            for(int noFloor =2;noFloor <=f; noFloor++){
                int minAttempt = Integer.MAX_VALUE;
                int low = 1 ;
                int high = noFloor;
                while(low <= high){
                    int mid = (high + low )/2;
                    int breaking = dp[noEggs-1] [mid-1];
                    int notBreaking = dp[noEggs]  [noFloor - mid];
                    int temp = 1 + Integer.max(breaking, notBreaking);
                    minAttempt = Integer.min(minAttempt, temp);

                    if(breaking < notBreaking){
                        low = mid +1;
                    }else{
                        high = mid - 1;
                    }
                }

                dp[noEggs][noFloor] = minAttempt;
            }
        }

        return dp[e][f];
    }


    static int findBinarySearchTabSO(int e, int f){

        // int[][] dp = new int[e+1][f+1];

        int[] prev = new int[f+1];
        int[] curr = new int[f+1];

      /* for(int i=0 ; i<e+1;i++){
         //  dp[i][1] = 1;
           curr[1]=1;
       }*/
        curr[1]=1;

        for(int j=0;j<f+1;j++){
            //  dp[1][j] = j;
            prev[j]= j;
        }




        for(int noEggs = 2;noEggs <=e; noEggs++){
            for(int noFloor =2;noFloor <=f; noFloor++){
                int minAttempt = Integer.MAX_VALUE;
                int low = 1 ;
                int high = noFloor;
                while(low <= high){
                    int mid = (high + low )/2;
                    int breaking = prev [mid-1];
                    int notBreaking = curr  [noFloor - mid];
                    int temp = 1 + Integer.max(breaking, notBreaking);
                    minAttempt = Integer.min(minAttempt, temp);

                    if(breaking < notBreaking){
                        low = mid +1;
                    }else{
                        high = mid - 1;
                    }
                }

                curr[noFloor] = minAttempt;
            }
            prev =curr.clone();
        }

        return prev[f];
    }
}
