package com.practice;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        Permutation p = new Permutation();
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = p.permute(arr);
        System.out.println(res);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        find(nums, 0, list, res);

        return res;
    }

    void find(int[] nums, int ind, List<Integer> list, List<List<Integer>> res ){

        if(ind == nums.length){
            // System.out.println("list << "+ list);
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=ind; i< nums.length;i++){
            list.add(nums[i]);
            swap(nums, i, ind);
            find(nums, ind+1, list, res);
            list.remove(list.size()-1);
            swap(nums, i, ind);
        }
    }

    void swap(int[] nums, int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
