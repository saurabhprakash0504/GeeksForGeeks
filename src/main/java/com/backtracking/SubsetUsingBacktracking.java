package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetUsingBacktracking {

    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        find(nums, 0, l, res);
        //  backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    //recursive approach
  /*  void find(int[] nums, int ind, List<Integer> l, List<List<Integer>> res){

        if(ind == nums.length){
            res.add(new ArrayList<>(l));
            return;
        }

         l.add(nums[ind]);
        find(nums, ind+1, l, res);

        l.remove(l.size()-1);
        find(nums, ind+1, l, res);
    }*/


    //Backtracking approach
    // we are not using swap here as we are not changing the position of the elements in the array as in permutation
    //unlike permutation we are not using swap here as we are not changing the position of the elements in the array as in permutation
    void find(int[] nums, int ind, List<Integer> list, List<List<Integer>> res){

        //adding in res
        res.add(new ArrayList<>(list));

        if(ind == nums.length){
            return;
        }

        for(int i=ind; i< nums.length;i++){
            list.add(nums[i]);
            // swap(nums, i, ind);

            //change in find method as we are passing i instead of ind as in permutation
            find(nums, i+1, list, res);
            list.remove(list.size()-1);

            // swap(nums, i, ind);

        }

    }
}
