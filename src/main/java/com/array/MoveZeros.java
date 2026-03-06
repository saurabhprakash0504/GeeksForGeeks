package com.array;

public class MoveZeros {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        MoveZeros obj = new MoveZeros();
        obj.moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public void moveZeroes(int[] nums) {

        int nonZeroInd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, nonZeroInd);
                nonZeroInd++;
            }
        }

        for (int i = nonZeroInd; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
