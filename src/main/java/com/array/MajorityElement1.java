package com.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement1 {

    public static void main(String[] args) {
        MajorityElement1 me = new MajorityElement1();
        int arr[] = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(me.majorityElement(arr));
    }

    int majorityElement(int arr[]) {

        // return find(arr);

        return findOpt(arr);
    }

    // Yt- TakeUforward
    int findOpt(int[] arr) {


        int ele = -1;
        int count = 0;

        for (int a : arr) {


            if (ele == a) {
                count++;
            } else if (count == 0) {
                ele = a;
                count = 1;
            } else if (ele != a) {
                count--;
            }

        }

        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                count++;
            }
        }

        if (count > arr.length / 2) {
            return ele;
        } else {
            return -1;
        }


    }

    int find(int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int a : arr) {
            int val = map.getOrDefault(a, 0);
            map.put(a, val + 1);
        }

        int maxVal = 0;
        int maxKey = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //  System.out.println("key >> "+ entry.getKey() + " value >> "+ entry.getValue());
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                maxKey = entry.getKey();

            }
        }

        if (maxVal > arr.length / 2) {
            return maxKey;
        } else {
            return -1;
        }
    }
}
