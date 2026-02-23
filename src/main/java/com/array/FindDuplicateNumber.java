package com.array;

public class FindDuplicateNumber {

    public static void main(String[] args) {

        int[] arr = {1,3,4,2,2};
        FindDuplicateNumber f = new FindDuplicateNumber();
        System.out.println(f.findDuplicate(arr));
    }

    //YT - Nikhil Lohia
    //BUT code is from my own and chatgpt.
    public int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;

        while (nums[slow] != nums[fast] || slow == 0) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (nums[slow] != nums[fast]) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return nums[slow];
    }
}
