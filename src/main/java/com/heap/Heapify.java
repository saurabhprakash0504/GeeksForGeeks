package com.heap;

import java.util.Arrays;

public class Heapify {

    public static void main(String[] args) {

        Heap h1 = new Heap(8);

       /*  h1.createMinHeap(3);
        h1.createMinHeap(2);
       h1.createMinHeap(15);
        h1.createMinHeap(20);
        h1.createMinHeap(1);

        System.out.println("before heapify >>> "+ Arrays.toString(h1.arr));

      //  h1.heapify(0);

        //System.out.println("After heapify >>> "+ Arrays.toString(h1.arr));

        System.out.println(h1.extractMin());*/

     /*   h1.createMinHeap(10);
        h1.createMinHeap(20);
        h1.createMinHeap(40);
        h1.createMinHeap(80);
        h1.createMinHeap(100);
        h1.createMinHeap(70);

        System.out.println("before decrease key >>> "+ Arrays.toString(h1.arr));

        h1.decreseKey(3, 5);

        System.out.println("after decrease key >>> "+ Arrays.toString(h1.arr));*/


/*
        h1.createMinHeap(10);
        h1.createMinHeap(20);
        h1.createMinHeap(30);
        h1.createMinHeap(40);
        h1.createMinHeap(50);
        h1.createMinHeap(35);
        h1.createMinHeap(38);
        h1.createMinHeap(45);

        System.out.println("before deleting >>> "+ Arrays.toString(h1.arr));

        h1.deleteAnIndex(3);

        System.out.println("after deleting >>> "+ Arrays.toString(h1.arr));*/
        
        h1.insert(10);
        h1.insert(5);
        h1.insert(20);
        h1.insert(2);
        h1.insert(4);
        h1.insert(8);
        System.out.println(" before creating a heap >>" + Arrays.toString(h1.arr));
        h1.buildHeap(h1.arr);
        System.out.println("after creating a heap >> "+ Arrays.toString(h1.arr));


    }
}
