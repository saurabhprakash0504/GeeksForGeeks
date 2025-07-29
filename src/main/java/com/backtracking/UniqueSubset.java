package com.backtracking;

import java.util.*;

public class UniqueSubset {

    public static void main(String[] args) {
        int N = 3, arr[] = {2, 1, 2};

        ArrayList<ArrayList<Integer>> list = AllSubsets(arr, N);

        for(ArrayList<Integer> l : list){
            System.out.println(l);
        }

    }


    // Function to find all possible unique subsets.
    public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {
        // your code here public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {
        // your code here
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> fl = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();

        find(arr, n, fl, l, 0);

        fl.sort((a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                if (!a.get(i).equals(b.get(i))) return a.get(i) - b.get(i);
            }
            return a.size() - b.size();
        });

        return fl;
    }

    static void find(int arr[], int n, ArrayList<ArrayList<Integer>> fl, ArrayList<Integer> l, int i) {

        if (i == n) {
            fl.add(new ArrayList(l));
            return;
        }


        l.add(arr[i]);
        find(arr, n, fl, l, i + 1);

        //  int k = l.get(l.size()-1);
        l.remove(l.size() - 1);

        int p = i + 1;
        while (p < n && arr[p] == arr[i]) {
            p = p + 1;
        }

        find(arr, n, fl, l, p);


    }
}
