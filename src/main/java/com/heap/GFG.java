package com.heap;

import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GFG {
    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            MinHeaps h = new MinHeaps(a);
            for (int i = 0; i < a; i++) {
                int c = sc.nextInt();
                int n;
                if (c == 1) {
                    n = sc.nextInt();
                    h.insertKey(n);
                }
                if (c == 2) {
                    n = sc.nextInt();
                    h.deleteKey(n);
                }
                if (c == 3) {
                    System.out.print(h.extractMin() + " ");
                }
            }
            System.out.println();

            System.out.println("~");
        }*/

        int[] arr = {33, 122, 359};
        MinHeaps h = new MinHeaps(800);
        for (int u : arr) {
            h.insertKey(u);
        }
        System.out.println("MINHeap");
        h.deleteKey(0);
        System.out.println("after delete key");
        int[] arr1 = {128, 709};
        for (int u : arr1) {
            h.insertKey(u);
        }
        h.deleteKey(0);
        h.extractMin();
        System.out.println("extract min");
    }
}

class MinHeaps {
    int[] harr;
    int capacity;
    int heap_size;

    MinHeaps(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    //Function to extract minimum value in heap and then to store
    //next minimum value at first index.
    int extractMin() {
        int min = -1;
        // Your code here.
        if (heap_size == 0) {
            return min;
        } else if (heap_size == 1) {
            min = harr[0];
            heap_size--;
            return min;
        } else {
            min = harr[0];
            swap(harr, 0, heap_size - 1);
            harr[heap_size - 1] = 0;
            heap_size--;
            minHeap(harr, 0, heap_size - 1);
            return min;
        }
    }

    //Function to insert a value in Heap.
    void insertKey(int k) {
        if (capacity > heap_size) {
            harr[heap_size] = k;
            heap_size++;
            if (heap_size == 1) {
                return;
            }
            int parent = (heap_size - 2) / 2;
            for (int i = parent; i >= 0; i--) {
                minHeap(harr, i, heap_size - 1);
            }
        }
    }

    void minHeap(int[] arr, int parent, int finalSize) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int smallest = parent;
        if (left <= finalSize && arr[smallest] > arr[left]) {
            smallest = left;
        }
        if (right <= finalSize && arr[smallest] > arr[right]) {
            smallest = right;
        }
        if (parent != smallest) {
            swap(arr, smallest, parent);
        }
    }

    void swap(int[] arr, int smallest, int parent) {
        int temp = arr[parent];
        arr[parent] = arr[smallest];
        arr[smallest] = temp;
    }

    //Function to delete a key at ith index.
    void deleteKey(int i) {
        if (i < 0) {
            return;
        }

        if (heap_size == 1) {
            harr[0] = 0;
            heap_size--;
        } else if (heap_size > i) {
            swap(harr, i, heap_size - 1);
            harr[heap_size - 1] = 0;
            heap_size--;
            minHeap(harr, 0, heap_size - 1);
        }
    }

    //Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val) {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}
