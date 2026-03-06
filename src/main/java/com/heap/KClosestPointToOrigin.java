package com.heap;

import java.util.PriorityQueue;

public class KClosestPointToOrigin {


    public int[][] kClosest(int[][] points, int k) {

        // Max-heap storing {distance, x, y}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0])  // compare by distance
        );

        for (int[] p : points) {
            int x = p[0];
            int y = p[1];
            int dist = x * x + y * y;  // calculate distance

            // Store distance and coordinates
            maxHeap.offer(new int[]{dist, x, y});

            // Keep only k closest
            if (maxHeap.size() > k) {
                maxHeap.poll();  // remove farthest
            }
        }

        // Build result
        int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            int[] entry = maxHeap.poll();
            result[i][0] = entry[1];  // x
            result[i][1] = entry[2];  // y
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        KClosestPointToOrigin solution = new KClosestPointToOrigin();
        int[][] closestPoints = solution.kClosest(points, k);

        System.out.println("The " + k + " closest points to the origin are:");
        for (int[] point : closestPoints) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }

}
