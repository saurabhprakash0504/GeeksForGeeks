package com.array;

import java.util.ArrayList;
import java.util.Collections;

public class MajorityElement2 {

    public static void main(String[] args) {
        MajorityElement2 me2 = new MajorityElement2();
        int arr[] = {1, 2, 3, 1, 1, 2, 2, 2};
        System.out.println(me2.findMajority(arr));
    }

    public ArrayList<Integer> findMajority(int[] arr) {

        ArrayList<Integer> finalList = new ArrayList<Integer>();

        find(arr, finalList);

        return finalList;
    }

    void find(int[] arr, ArrayList<Integer> finalList) {

        int ele1 = -1;
        int count1 = 0;

        int ele2 = -1;
        int count2 = 0;

        for (int a : arr) {

            if (ele1 == a) {
                count1++;
            } else if (ele2 == a) {
                count2++;
            } else if (count1 == 0 && ele2 != a) {
                count1 = 1;
                ele1 = a;

            } else if (count2 == 0 && ele1 != a) {
                count2 = 1;
                ele2 = a;

            } else {
                count1--;
                count2--;
            }

        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele1) {
                count1++;
            } else if (arr[i] == ele2) {
                count2++;
            }

        }

        if (count1 > arr.length / 3) {
            finalList.add(ele1);
        }
        if (count2 > arr.length / 3) {
            finalList.add(ele2);
        }

        Collections.sort(finalList);


    }
}
