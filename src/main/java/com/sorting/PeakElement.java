package com.sorting;

public class PeakElement {

    public static void main(String[] args) {
        PeakElement obj = new PeakElement();
        int[] arr = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(obj.peakElement(arr));
    }

    public int peakElement(int[] arr) {
        // code here


        int s = 0;
        int e = arr.length - 1;
        //  mid = s + (e-s)/2;
        while (s < e) {
            int mid = s + (e - s) / 2;
            //if(mid > 0 && arr[mid] > arr[mid-1]){
            if (arr[mid] < arr[mid + 1]) {
                s = mid + 1;
            } else {
                e = mid;
            }

        }
        return s;
    }
}
