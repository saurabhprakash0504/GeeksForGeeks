package com.searching;

public class FindingAnElementInRotatedArray {
    public static void main(String[] args) {
        method2();
    }

    static void method1(int[] arr) {
        int[] arr2 = sortArray(arr);
        System.out.println(binarySearch(arr2, 40, 0, arr.length - 1));
    }

    static int[] sortArray(int[] arr) {
        int[] temp = new int[arr.length];
        int max = 0;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        System.out.println("max >>" + max);
        System.out.println("min >> " + min);
        int j = 0;
        for (int i = min; i < temp.length; i++) {
            temp[j] = arr[i];
            j++;
        }
        for (int i = 0; i < min; i++) {
            temp[j] = arr[i];
            j++;
        }
        System.out.println("temp");
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        return temp;
    }

    static int binarySearch(int[] arr, int value, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return binarySearch(arr, value, start, mid - 1);
        } else {
            return binarySearch(arr, value, mid + 1, end);
        }
    }

    static void method2() {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(arr, target));
    }

    public static int search(int[] nums, int target) {

        if (nums[0] <= nums[nums.length - 1]) {
            return binarySearch1(nums, 0, nums.length - 1, target);
        }
        int lowPeakIndex = findPeak(nums);
        if (target >= nums[0]) {
            return binarySearch1(nums, 0, lowPeakIndex - 1, target);
        } else {
            return binarySearch1(nums, lowPeakIndex, nums.length - 1, target);
        }

    }

	//This method is to find the index of the smallest element in the rotated sorted array.
    static int findPeak(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int m = s + (e - s) / 2;

        while (s < e) {
            if (nums[m] >= nums[0]) {
                s = m + 1;
            } else {
                e = m;
            }

            m = s + (e - s) / 2;
        }

        return s;
    }


    static int binarySearch1(int[] nums, int s, int e, int target) {

        int m = s + (e - s) / 2;
        while (s <= e) {
            if (nums[m] == target) {
                return m;
            } else if (target > nums[m]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
            m = s + (e - s) / 2;
        }
        return -1;
    }
}
