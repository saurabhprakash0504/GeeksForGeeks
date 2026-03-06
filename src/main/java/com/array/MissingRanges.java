package com.array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static void main(String[] args) {

        int[] arr = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        MissingRanges obj = new MissingRanges();
        List<List<Integer>> res = obj.missingRanges(arr, lower, upper);
        for (List<Integer> l : res) {
            System.out.println(l.get(0) + " " + l.get(1));
        }
    }

    public List<List<Integer>> missingRanges(int[] arr, int lower, int upper) {
        // code here
        int s = lower;
        int e = upper;

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (s == arr[i]) {
                //  continue;
            } else {

                res.add(List.of(s, arr[i] - 1));

            }
            s = arr[i] + 1;

        }
        if (arr[arr.length - 1] == upper) {
            return res;
        } else {
            res.add(List.of(arr[arr.length - 1] + 1, e));
            return res;
        }

    }

}
