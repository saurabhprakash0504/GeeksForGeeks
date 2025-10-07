package com.array;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int key = 0;
        int ans = obj.search(arr, key);
        System.out.println("ans >> " + ans);
    }

    int search(int[] arr, int key) {
        // code here

        int pivot = findPivot(arr);
        //   System.out.println("pivot >> "+ pivot);

        if (key >= arr[pivot] && key <= arr[arr.length - 1]) {
            return binarySearch(arr, pivot, arr.length - 1, key);
        } else {
            return binarySearch(arr, 0, pivot - 1, key);
        }

    }

    int findPivot(int[] arr) {

        int s = 0;
        int e = arr.length - 1;

        int mid = s + (e - s) / 2;

        while (s < e) {

            if (arr[mid] >= arr[0]) {
                s = mid + 1;
            } else {
                e = mid;
            }
            mid = s + (e - s) / 2;
        }
        return s;

    }


    int binarySearch(int[] arr, int s, int e, int key) {

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;

    }


}
