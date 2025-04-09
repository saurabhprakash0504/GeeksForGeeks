package com.heap;

import java.util.Arrays;

public class HeapSort {

    static class Heap {
        int[] arr;
        int nextFreeIndex;
        int capacity;


        Heap(int capacity) {
            arr = new int[capacity];
            nextFreeIndex = 0;
            this.capacity = capacity;
        }

        int parentIndex(int index) {
            return (index - 1) / 2;
        }

        int leftChild(int index) {
            return 2 * index + 1;
        }

        int rightChild(int index) {
            return 2 * index + 2;
        }


        void insert(int val) {
            if (nextFreeIndex < capacity) {
                arr[nextFreeIndex] = val;
                nextFreeIndex++;
            }
        }

        void buildMaxHeap() {
            int parent = (nextFreeIndex - 2) / 2;
            for (int i = parent; i >= 0; i--) {
                maxHeapify(i, nextFreeIndex);

            }

            swap(0, nextFreeIndex - 1);
            int start =0;
            int end = nextFreeIndex - 1 ;
            while (start < end){
                maxHeapify(0, end);
                swap(0, end-1);
                end--;
            }

            System.out.println("arrays final sorted " + Arrays.toString(arr));

        }


        void maxHeapify(int index, int end) {
            int left = leftChild(index);
            int right = rightChild(index);
            int biggestIndex = index;
            if (left < end && arr[left] > arr[biggestIndex]) {
                biggestIndex = left;
            }
            if (right < end  && arr[right] > arr[biggestIndex]) {
                biggestIndex = right;
            }

            if (biggestIndex != index) {
                swap(biggestIndex, index);
            }
        }


        void swap(int parentIndex, int childIndex) {
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[childIndex];
            arr[childIndex] = temp;

        }
    }


    public static void main(String[] args) {
        Heap heap = new Heap(6);
        heap.insert(100);
        heap.insert(50);
        heap.insert(50);
        heap.insert(4);
        heap.insert(20);
        heap.insert(14);

        heap.buildMaxHeap();
    }
}
