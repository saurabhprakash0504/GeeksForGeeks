package com.binarySearchTree;

import java.util.Arrays;
import java.util.TreeSet;

public class CeilingOnLeftSideOfArray {

    public static void main(String[] args) {
        int[] arr = {2, 8, 30, 15, 25, 12};
        int[] ans = findCeiling(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] findCeiling(int[] arr) {
        int[] newA = new int[arr.length];
        TreeSet<Integer> set = new TreeSet<>();
        newA[0] = -1;
        set.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (set.ceiling(arr[i]) == null)
                newA[i] = -1;
            else {
                int val = set.ceiling(arr[i]);
                newA[i] = val;
            }
            set.add(arr[i]);
        }
        return newA;
    }
}
