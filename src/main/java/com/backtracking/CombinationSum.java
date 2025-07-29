package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();

        Arrays.sort(arr); // Optional: helps avoid duplicates, though not strictly needed

        find(arr, target, res, l, 0);

        return res;
    }

    static void find(int[] arr, int rem, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l, int index) {
        if (rem == 0) {
            result.add(new ArrayList<>(l));
            return;
        }

        if (rem < 0) {
            return;
        }

        for (int i = index; i < arr.length; i++) {
            l.add(arr[i]);
            find(arr, rem - arr[i], result, l, i); // allow same element again
            l.remove(l.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8};
        int target = 8;
        ArrayList<ArrayList<Integer>> results = combinationSum(arr, target);
        System.out.println(results);
    }
}
