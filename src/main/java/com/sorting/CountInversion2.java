package com.sorting;

public class CountInversion2 {

    public static void main(String[] args) {
        int arr[] = {5, 4, 1, 2, 1, 7, 3};
        int result = inversionCount(arr);
        System.out.println(result);
    }


    static int inversionCount(int arr[]) {

        return mergeSort(arr, 0, arr.length - 1);

    }

    static int mergeSort(int[] arr, int s, int e) {
        if (s >= e) {
            return 0;
        }

        int m = s + (e - s) / 2;
        int a = mergeSort(arr, s, m);
        int b = mergeSort(arr, m + 1, e);

        int c = merge(arr, s, e);

        return a + b + c;

    }

    static int merge(int[] arr, int s, int e) {
        int count = 0;
        int m = s + (e - s) / 2;

        int len1 = (m - s) + 1;
        int len2 = (e - (m + 1)) + 1;

        int[] tem1 = new int[len1];
        int[] tem2 = new int[len2];

        int i = 0;
        int ss = s;
        while (i < len1) {
            tem1[i] = arr[ss];
            ss++;
            i++;
        }

        int j = 0;
        int dd = m + 1;
        while (j < len2) {
            tem2[j] = arr[dd];
            dd++;
            j++;
        }

        i = 0;
        j = 0;
        while (i < len1 && j < len2) {
            if (tem1[i] <= tem2[j]) {
                arr[s] = tem1[i];
                i++;
                s++;
            } else {
                count = count + (len1 - i);
                arr[s] = tem2[j];
                j++;
                s++;
            }
        }

        while (i < len1) {
            arr[s] = tem1[i];
            i++;
            s++;
        }

        while (j < len2) {
            arr[s] = tem2[j];
            j++;
            s++;
        }

        return count;
    }
}
