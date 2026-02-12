package com.dynamicProgramming;

import java.util.Arrays;

public class HouseRobbery4 {

    public static void main(String[] args) {

        int[] nums = {2, 3, 5, 9};
        int k = 2;

        //BINARY SEARCH IS THE TOP APPROACH FOR THIS PROBLEM, BUT I HAVE DONE IT USING RECURSION AND MEMOIZATION
        HouseRobbery4 hr = new HouseRobbery4();
        int answer = hr.minCapability(nums, k);
        System.out.println(answer);


    }



    public int minCapability(int[] nums, int k) {

        // return find(nums, k, 0);

        int[][] dp = new int[nums.length + 1][k + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findMem(nums, k, 0, dp);

    }

    int find(int[] nums, int k, int curr) {
        if (k == 0) {
            return 0;
        }

        if (curr >= nums.length) {
            return Integer.MAX_VALUE;
        }

        int inc = Integer.max(nums[curr], find(nums, k - 1, curr + 2));
        int exc = find(nums, k, curr + 1);

        return Integer.min(inc, exc);

    }

    int findMem(int[] nums, int k, int curr, int[][] dp) {
        if (k == 0) {
            return 0;
        }

        if (curr >= nums.length) {
            return Integer.MAX_VALUE;
        }

        if (dp[curr][k] != -1) {
            return dp[curr][k];
        }

        int inc = Integer.max(nums[curr], findMem(nums, k - 1, curr + 2, dp));
        int exc = findMem(nums, k, curr + 1, dp);


        return dp[curr][k] = Integer.min(inc, exc);

    }
}
