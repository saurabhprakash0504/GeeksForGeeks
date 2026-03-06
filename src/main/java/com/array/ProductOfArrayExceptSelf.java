package com.array;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int[] result = obj.productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Expected output: [24, 12, 8, 6]
    }


    public int[] productExceptSelf(int[] nums) {
        int prefixProduct = 1;
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefixProduct;
            prefixProduct = prefixProduct * nums[i];
        }
        //  System.out.println("res > " + Arrays.toString(res));

        int suffixProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = suffixProduct * res[i];
            suffixProduct = suffixProduct * nums[i];
        }

        return res;
    }

}
