package com.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {

    public static void main(String[] args) {
        int[] arr = {10, 9, 7, 8, 4, 70, 50, 60};
        System.out.println(Arrays.toString(sortKArray(arr, 4)));
    }

    static int[] sortKArray(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            priorityQueue.add(arr[i]);
        }
        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[index] = priorityQueue.poll();
            priorityQueue.add(arr[i]);
            index++;
        }
        for (int i = arr.length - 1 - k; i < arr.length; i++) {
            arr[index] = priorityQueue.poll();
            index++;
        }

        return arr;
    }
}
