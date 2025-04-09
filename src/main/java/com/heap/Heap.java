package com.heap;

import java.util.Arrays;

public class Heap {

    int[] arr;
    int nextFreeIndex;
    int capacity;

    Heap(int capacity) {
        arr = new int[capacity];
        nextFreeIndex = 0;
        this.capacity = capacity;
    }


    int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    int left(int currIndex) {
        return (2 * currIndex + 1);
    }

    int right(int currIndex) {
        return (2 * currIndex + 2);
    }


    void createMinHeap(int val) {

        if (nextFreeIndex == (capacity)) {
            return;
        }

        arr[nextFreeIndex] = val;
        nextFreeIndex++;

        insertInRightPlace(nextFreeIndex - 1);

    }

    void insertInRightPlace(int currIndex) {

        if (currIndex == 0) {
            return;
        }
        int parentIndex = getParentIndex(currIndex);

        if (arr[parentIndex] <= arr[currIndex]) {
            return;
        }

        swap(parentIndex, currIndex);

        insertInRightPlace(parentIndex);

    }

    void swap(int parentIndex, int currIndex) {
        int temp = arr[parentIndex];
        arr[parentIndex] = arr[currIndex];
        arr[currIndex] = temp;
    }


    /// Heapify


    void heapify(int index) {
        int left = left(index);
        int right = right(index);
        int smallestIndex = index;

        if (left < nextFreeIndex && arr[left] < arr[smallestIndex]) {
            smallestIndex = left;
        }

        if (right < nextFreeIndex && arr[right] < arr[smallestIndex]) {
            smallestIndex = right;

        }

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapify(smallestIndex);
        }
    }

    public int extractMin() {

        if (nextFreeIndex == 0) {
            return Integer.MIN_VALUE;
        }

        int val = arr[0];

        if (nextFreeIndex == 1) {
            nextFreeIndex--;
            return val;
        }

        arr[0] = arr[nextFreeIndex - 1];
        arr[nextFreeIndex - 1] = 0;
        nextFreeIndex--;
        heapify(0);
        return val;
    }

    public void insert(int x) {
        if (nextFreeIndex == capacity) return;
        nextFreeIndex++;
        arr[nextFreeIndex - 1] = x;
    }


    void decreseKey(int index, int val) {

        arr[index] = val;

        compareParents(index);

    }

    void compareParents(int index) {

        if (index == 0) {
            return;
        }

        int paremntIndex = getParentIndex(index);

        if (arr[paremntIndex] <= arr[index]) {
            return;
        }

        swap(paremntIndex, index);

        compareParents(paremntIndex);

    }


    void deleteAnIndex(int index) {

        if (index < nextFreeIndex) {

            arr[index] = -Integer.MIN_VALUE;

            decreseKey(index, arr[index]);

            System.out.println("after decrease key >> " + Arrays.toString(arr));

            extractMin();

        }

    }


    void buildHeap(int[] arr) {
        int startingIndex = ((nextFreeIndex - 1) - 1) / 2;
        for (int i = startingIndex; i >= 0; i--) {
            heapify(i);
        }
    }


}
