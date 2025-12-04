package com.searching;

public class PainterPartitionProblem {

    public static void main(String[] args) {

        PainterPartitionProblem obj = new PainterPartitionProblem();
        int[] arr = {10, 20, 30, 40};
        int k = 2;
        System.out.println(obj.minTime(arr, k));
    }

    public int minTime(int[] arr, int k) {
        // code here
        int s = 0;
        int e = 0;
        for (int i = 0; i < arr.length; i++) {
            e = e + arr[i];
        }
        int m = s + (e - s) / 2;
        int res = -1;
        while (s <= e) {
            if (isPossible(arr, k, m)) {
                res = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
            m = s + (e - s) / 2;
        }
        return res;
    }

    boolean isPossible(int[] arr, int k, int m) {

        int painterC = 1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= m) {
                sum = sum + arr[i];
            } else if (painterC + 1 > k || arr[i] > m) {
                return false;
            } else {
                painterC++;
                sum = arr[i];
            }
        }

        return true;

    }
}
