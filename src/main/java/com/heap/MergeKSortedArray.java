package com.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {

    static class MergeArray {

        int val;
        int arrPosition;
        int indexPosition;

        MergeArray() {

        }

        MergeArray(int val, int arrPosition, int indexPosition) {
            this.val = val;
            this.arrPosition = arrPosition;
            this.indexPosition = indexPosition;
        }


        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getArrPosition() {
            return arrPosition;
        }

        public void setArrPosition(int arrPosition) {
            this.arrPosition = arrPosition;
        }

        public int getIndexPosition() {
            return indexPosition;
        }

        public void setIndexPosition(int indexPosition) {
            this.indexPosition = indexPosition;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{4, 5, 6}, {1, 2}, {7}, {3, 9}};

        MergeKSortedArray mergeKSortedArray = new MergeKSortedArray();
        int[] finalArr = mergeKSortedArray.mergeSortedArray(arr);

        System.out.println(Arrays.toString(finalArr));
    }

    int[] mergeSortedArray(int[][] arr) {
        int totalLength = 0;

        PriorityQueue<MergeArray> priorityQueue = new PriorityQueue<>(new Comparator<MergeArray>() {
            @Override
            public int compare(MergeArray o1, MergeArray o2) {
                return o1.val - o2.val;
            }
        });


        for (int i = 0; i < arr.length; i++) {
            totalLength = totalLength + arr[i].length;
            priorityQueue.add(new MergeArray(arr[i][0], i, 0));
        }

        int[] finalArray = new int[totalLength];

        for (int i = 0; i < totalLength; i++) {
            MergeArray lowestVal = priorityQueue.poll();

            finalArray[i] = lowestVal.getVal();

            int currValArrPos = lowestVal.getArrPosition();

            int currValIndexPos = lowestVal.getIndexPosition();

            if (currValIndexPos + 1 < arr[currValArrPos].length) {

                priorityQueue.add(new MergeArray(arr[currValArrPos][currValIndexPos + 1], currValArrPos, currValIndexPos + 1));

            }


        }

        return finalArray;
    }
}
