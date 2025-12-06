package com.sorting;

public class CountInversions {

    public static void main(String[] args) {

        int arr[] = {5, 4, 1, 2, 1, 7, 3};
        int result = inversionCount(arr);
        System.out.println(result);
    }

    static int count = 0;

    static int inversionCount(int arr[]) {
        // Code Here
  /*      int count =0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;*/
        count = 0;
        mergeSort(arr, 0, arr.length - 1);

        //    System.out.println(Arrays.toString(arr));

        return count;
    }

    static void mergeSort(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }

        int m = s + (e - s) / 2;
        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);

        merge(arr, s, e);


    }

    static void merge(int[] arr, int s, int e) {

        int m = s + (e - s) / 2;

        int len1 = (m - s) + 1;
        int len2 = (e - (m + 1)) + 1;
       /* System.out.println("s > "+ s);
        System.out.println("m > "+ m);
        System.out.println("e > "+ e);
        System.out.println("l1 > "+ len1);
        System.out.println("l2 > "+ len2);*/

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
                // count++;
                // System.out.println("tem1[i] > "+ tem1[i]);
                //System.out.println("tem2[j] > "+ tem2[j]);
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
            // count++;
            arr[s] = tem2[j];
            j++;
            s++;
        }

    }
}
