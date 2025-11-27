package com.practice;

import java.util.PriorityQueue;

public class FindKthLargestElement {

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50, 70};
        // 1, 2, 9, 12, 23, 30, 50, 70
        int k = 8;

        System.out.println(find(arr, k));;
    }

    static int find(int[] arr, int k){
        if (k > arr.length){
            return -1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>( );
        for(int a : arr){
            queue.add(a);
        }

        int i=1;
        while ( i < k){
            queue.poll();
            i++;
        }

        return queue.poll();

    }
}
