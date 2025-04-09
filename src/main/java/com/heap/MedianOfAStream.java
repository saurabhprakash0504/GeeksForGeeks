package com.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfAStream {

    public static void main(String[] args) {
        //int[] arr = {25, 7, 10, 15, 20};
        int[] arr = {12, 15, 10, 5, 8 , 7 ,16};
        System.out.println(Arrays.toString(median(arr)));
    }

    static double[] median(int[] input) {

        double[] result = new double[input.length];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(input[0]);
        result[0] = input[0];
        for (int i = 1; i < input.length; i++) {
            if (maxHeap.size() == minHeap.size()) {
                if (input[i] > maxHeap.peek() && input[i] > minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(input[i]);
                } else {
                    maxHeap.add(input[i]);
                }
                result[i] = maxHeap.peek();
            } else {
                if (input[i] > maxHeap.peek()) {
                    minHeap.add(input[i]);
                } else {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(input[i]);
                }
                double avg = (maxHeap.peek() + minHeap.peek()) / (2 * 1.0);
                result[i] = avg;
            }
        }
        // }

        return result;
    }
}
