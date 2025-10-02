package com.practice;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {

        NextPermutation np = new NextPermutation();
        //int[] arr = {2, 4, 1, 7, 5, 0};
        int[] arr = {1,2,3,6,5,4};
        np.nextPermutation(arr);
        for(int i: arr){
            System.out.print(i+" ");
        }

    }
    void nextPermutation(int[] arr) {
        // code here
        find(arr);
    }

    void find(int[] arr){
        int prev= arr[arr.length-1];
        int ind = -1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i] < prev ){
                ind = i;
                break;
            }
            prev = arr[i];
        }

        int maxInd = -1;
        int opp= arr.length-1;
        while(opp > ind){
            if(maxInd == -1 && arr[opp] > arr[ind]){
                maxInd = opp;
            }else if(maxInd != -1 && arr[opp] >  arr[ind] && arr[opp] < arr[maxInd] ){
                maxInd = opp;
            }
            opp = opp-1;
        }

        if(maxInd != -1){

            int temp =arr[maxInd];
            arr[maxInd] = arr[ind];
            arr[ind] = temp;

        }

        System.out.println("arr "+ Arrays.toString(arr));

        //Sort

        if(ind != -1)
            Arrays.sort(arr,ind+1, arr.length);
        else
            Arrays.sort(arr);

    }

}
