package com.searching;

public class AllocateMinimumPages {

    public static void main(String[] args) {
        AllocateMinimumPages obj = new AllocateMinimumPages();
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(obj.findPages(arr, k));
    }

    public int findPages(int[] arr, int k) {
        if (k > arr.length) {
            return -1;
        }
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

    boolean isPossible(int[] arr, int stu, int m) {

        int stuC = 1;
        int pageS = 0;

        for (int i = 0; i < arr.length; i++) {
            if (pageS + arr[i] <= m) {
                pageS = pageS + arr[i];
            } else {
                stuC++;
                if (stuC > stu || arr[i] > m) {
                    return false;
                }
                pageS = 0;
                pageS = arr[i];
            }
        }
        return true;
    }
}
