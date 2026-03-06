package com.searching;

public class FindFirstAndLastPosInSortedArray {

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        FindFirstAndLastPosInSortedArray obj = new FindFirstAndLastPosInSortedArray();
        int[] res = obj.searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] searchRange(int[] nums, int target) {

        int s = 0;
        int e = nums.length - 1;
        int m = -1;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (nums[m] == target) {
                break;
            } else if (nums[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }

        }

        if (m != -1 && m < nums.length && nums[m] == target) {
            s = m;
            e = m;
            while (s >= 0 && nums[s] == nums[m]) {
                s--;
            }

            while (e < nums.length && nums[e] == nums[m]) {
                e++;
            }

            return new int[]{s + 1, e - 1};
        }

        return new int[]{-1, -1};


    }
}
