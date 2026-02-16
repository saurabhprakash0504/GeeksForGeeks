package com.searching;

public class HouseRobbery4 {

    public static void main(String[] args) {

        HouseRobbery4 obj = new HouseRobbery4();
        int[] nums = {2, 3, 5, 9};
        int k = 2;
        System.out.println(obj.minCapability(nums, k));
    }

    public int minCapability(int[] nums, int k) {
        int l = nums[0];
        int h = nums[0];
        for (int i = 0; i < nums.length; i++) {
            l = Integer.min(l, nums[i]);
            h = Integer.max(h, nums[i]);

        }

        int res = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isPossible(m, nums, k)) {
                res = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return res;
    }

    boolean isPossible(int m, int[] nums, int k) {
        int temp = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] <= m) {
                temp++;
                i = i + 2;
            } else {
                i = i + 1;
            }
        }

        boolean res = false;
        if (temp >= k) {
            res = true;
        }
        return res;
    }
}
