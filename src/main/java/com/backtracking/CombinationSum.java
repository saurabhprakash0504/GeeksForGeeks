package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
/*

    //Method 1 - ChatGPT - Working
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
*/


    //Method 2 - Take U forward - working
    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {


        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        ArrayList<Integer> l = new ArrayList<>();


        find(arr, target, al, l, 0 );

        return al;


    }

    static void find(int[] arr, int t, ArrayList<ArrayList<Integer>> al, ArrayList<Integer> l , int ind ){

        if(t == 0){
            al.add(new ArrayList<>(l));
            return;
        }

        if(t < 0 || ind == arr.length){
            return;
        }

        //   for(int i=ind;i<arr.length;i++){
        if(t >= arr[ind]){
            l.add(arr[ind]);
            find(arr, t- arr[ind], al, l, ind );
            l.remove(l.size()-1);
        }
        //   }

        find(arr, t, al, l, ind+1);

    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8};
        int target = 8;
        ArrayList<ArrayList<Integer>> results = combinationSum(arr, target);
        System.out.println(results);
    }
}
