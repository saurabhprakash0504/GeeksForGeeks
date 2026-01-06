package com.array;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {

    public static void main(String[] args) {

        FourSum obj = new FourSum();
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        ArrayList<ArrayList<Integer>> result = obj.fourSum(arr, target);
        System.out.println(result);

    }

    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        // code here
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
        Arrays.sort(arr);
        find(arr, target, finalList);
        return finalList;
    }

    void find(int[] arr, int target, ArrayList<ArrayList<Integer>> finalList) {

        for (int i = 0; i < arr.length; i++) {

            while (i - 1 >= 0 && i < arr.length && arr[i] == arr[i - 1]) {
                i++;
            }

            for (int j = i + 1; j < arr.length; j++) {

                while (j - 1 >= i + 1 && j < arr.length && arr[j] == arr[j - 1]) {
                    j++;
                }

                int k = j + 1;
                int l = arr.length - 1;

                while (k < l) {
                    //  System.out.println("ind   "+i+ " "+j +" "+k +" "+l );
                    //    System.out.println("value "+ arr[i]+ " "+arr[j] +" "+arr[k] +" "+arr[l] );
                    if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        finalList.add(temp);

                        k = k + 1;
                        while (k < l && arr[k] == arr[k - 1]) {
                            k++;
                        }

                        l = l - 1;
                        while (l > k && arr[l] == arr[l + 1]) {
                            l--;
                        }

                    } else if (arr[i] + arr[j] + arr[k] + arr[l] > target) {
                        l--;
                    } else {
                        k++;
                    }

                }

            }
        }
    }
}
