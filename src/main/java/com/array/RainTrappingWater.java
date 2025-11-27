package com.array;

public class RainTrappingWater {

    public static int maxWater(int arr[]) {
        // code here
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];


        left[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            left[i] = Integer.max(arr[i], left[i-1]);
        }

        right[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            right[i] = Integer.max(arr[i], right[i+1]);
        }

        int sum =0;
        for(int i=0;i< arr.length;i++){

            sum = sum + Math.abs(Integer.min(left[i], right[i]) - arr[i]);
        }

        return sum;

    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 1, 0, 4};
        System.out.println(maxWater(arr));
    }
}
