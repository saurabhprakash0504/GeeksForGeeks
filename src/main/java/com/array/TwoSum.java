package com.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int arr[] = {2, 7, 11, 15};
        int target = 9;
        List<Integer> res = ts.twoSum(arr, target);
        System.out.println(res);
    }

    public List<Integer> twoSum(int arr[], int target) {
        // Your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<>();
        for (int a : arr) {
            int diff = target - a;
            if (set.contains(diff)) {
                if (a < diff) {
                    list.add(a);
                    list.add(diff);
                } else {
                    list.add(diff);
                    list.add(a);
                }
            } else {
                set.add(a);
            }
        }

        return list;
    }
}
