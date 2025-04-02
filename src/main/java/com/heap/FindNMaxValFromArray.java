package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindNMaxValFromArray {

    public static void main(String[] args) {
        int[] arr = {7, 4, 3, 1, 2, 5, 6};
        System.out.println(findNthValue(arr, 3));
    }

    static int findNthValue(int[] array, int n) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < array.length; i++) {
            queue.add(array[i]);
        }
        int i = 1;
        while (i < n) {
            queue.poll();
            i++;
        }
        return queue.peek();
    }
}
