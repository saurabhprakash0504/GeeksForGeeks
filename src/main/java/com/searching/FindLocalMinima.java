package com.searching;

public class FindLocalMinima {

    public static void main(String[] args) {

        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(findMinima(nums));
    }

    public static int findMinima(int[] nums) {
        if(nums.length == 1){
            return 0;
        }

        if(nums[0] < nums[1]){
            return 0;
        }

        if(nums[nums.length-1] < nums[nums.length-2] ){
            return nums.length-1;
        }

        int l =1;
        int r = nums.length-2;

        while(l <= r){
            int m = l + (r-l)/2;

            if(nums[m] < nums[m-1] && nums[m] < nums[m+1]){
                return m;
            }else if(nums[m] < nums[m-1] && nums[m] > nums[m+1]){
                l = m+1;
            }else{
                r = m-1;
            }


        }

        return -1;
    }
}
