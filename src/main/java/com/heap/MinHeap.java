package com.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinHeap {

    public static void main(String[] args) {
        Heap h = new Heap(8);

        h.createMinHeap(3);
        h.createMinHeap(2);
        h.createMinHeap(15);
        h.createMinHeap(20);

        System.out.println("heap >> "+ Arrays.toString(h.arr));


    }



}
