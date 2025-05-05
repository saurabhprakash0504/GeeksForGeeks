package com.array;

public class MaxProductInSubArray {

    public static void main(String[] args) {
        //  int[] arr = {-2, 6, -3, -10, 0, 2};
        int[] arr = {-2, 0, -1};
        System.out.println(maxProduct(arr));
    }

    static int maxProduct(int[] arr) {
        // code here
       /* int max = arr[0];
        for(int i=0;i<arr.length;i++){
            int curr = arr[i];
             max = Integer.max(curr, max);
            for(int j=i+1;j<arr.length;j++){
                 curr = curr*arr[j];
                max = Integer.max(curr, max);
            }
        }
        return max;*/


        int max = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < arr.length; i++) {
            if (prefix == 0) {
                prefix = 1;
            }

            if (suffix == 0) {
                suffix = 1;
            }
            prefix = prefix * arr[i];
            suffix = suffix * arr[arr.length - i - 1];

            max = Integer.max(max, Integer.max(prefix, suffix));
        }
        return max;

    }
}
