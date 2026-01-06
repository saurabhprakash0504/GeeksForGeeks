package com.array;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> res = triplets(arr);
        System.out.println(res);
    }

    public static ArrayList<ArrayList<Integer>> triplets(int[] arr) {
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
        find(arr, finalList);
        return finalList;
    }

    static void find(int[] arr, ArrayList<ArrayList<Integer>> finalList) {

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            while (i - 1 >= 0 && i < arr.length && arr[i] == arr[i - 1]) {
                i++;
            }


            int firstInd = i;
            int secInd = firstInd + 1;
            int thirdInd = arr.length - 1;

            ArrayList<Integer> al = new ArrayList<>();
            while (secInd < thirdInd) {

                if (arr[firstInd] + arr[secInd] + arr[thirdInd] == 0) {
                    al.add(arr[firstInd]);
                    al.add(arr[secInd]);
                    al.add(arr[thirdInd]);
                    finalList.add(al);
                    al = new ArrayList<>();

                    int newS = secInd + 1;
                    while (newS < thirdInd && arr[newS] == arr[secInd]) {
                        newS = newS + 1;
                    }

                    int newT = thirdInd - 1;
                    while (newT > newS && arr[newT] == arr[thirdInd]) {
                        newT = newT - 1;
                    }
                    secInd = newS;
                    thirdInd = newT;

                } else if (arr[firstInd] + arr[secInd] + arr[thirdInd] > 0) {

                    thirdInd--;
                } else {
                    secInd++;
                }

            }

        }

    }
}
