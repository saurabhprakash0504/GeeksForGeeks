package com.heap;

import java.util.PriorityQueue;

public class BuyMaximumItemWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1, 12, 5, 111, 50};
        System.out.println(maxItem(arr, 180));
    }

    static int maxItem(int[] arr, int sum) {
        int result = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }

        while (priorityQueue.size() > 0 && sum >= priorityQueue.peek()) {
            sum = sum - priorityQueue.poll();
            result++;
        }
        return result;
    }
}
