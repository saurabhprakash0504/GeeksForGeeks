package com.dynamicProgramming;

public class MaxSumSubArrayByRemovingAtmostOne {

    public static void main(String[] args) {

        int arr[] = {1, -2, 0, 3};
        MaxSumSubArrayByRemovingAtmostOne obj = new MaxSumSubArrayByRemovingAtmostOne();
        System.out.println(obj.maxSumSubarray(arr));

    }

    public int maxSumSubarray(int arr[]) {
        // code here.
        int len = arr.length;
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        kadanesAlgo(arr, arr1);
        kadanesAlgoRev(arr, arr2);

        int max = arr1[0];
        for (int i = 1; i < arr.length; i++) {
            max = Integer.max(max, arr1[i]);
        }


        for (int i = 1; i < arr.length - 1; i++) {
            max = Integer.max(max, arr1[i - 1] + arr2[i + 1]);
        }


        return max;
    }

    void kadanesAlgo(int[] arr, int[] arr1) {

        // int currMax =arr[0];
        arr1[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
           /*if(arr[i] + prev > arr[i]){
               arr1[i] = arr[i]+prev;
               prev = arr[i]+prev;
           }else{
               arr1[i] = arr[i];
               prev = arr[i];
           }*/
           /*currMax = Integer.max(arr[i] + currMax , arr[i]);
           arr1[i]= currMax;*/
            arr1[i] = Integer.max(arr[i] + arr1[i - 1], arr[i]);
        }
    }

    void kadanesAlgoRev(int[] arr, int[] arr2) {

        //  int currMax =arr[arr.length-1];
        arr2[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
         /*  if(arr[i] + prev > arr[i]){
               arr2[i] = arr[i]+prev;
               prev = arr[i]+prev;
           }else{
               arr2[i] = arr[i];
               prev = arr[i];
           }*/

           /* currMax = Integer.max(arr[i] + currMax , arr[i]);
            arr2[i]= currMax;*/

            arr2[i] = Integer.max(arr[i] + arr2[i + 1], arr[i]);
        }
    }
}
