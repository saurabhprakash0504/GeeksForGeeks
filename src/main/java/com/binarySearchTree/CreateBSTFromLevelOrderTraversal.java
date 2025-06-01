package com.binarySearchTree;

import java.util.*;

public class CreateBSTFromLevelOrderTraversal {

    public static void main(String[] args) {
        int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        Node temp = constructBST(arr);
        System.out.println(" temp >> " + temp);

    }
// Working Code -- Written by myself
    //Video -  YT pepCoding
    public static Node constructBST(int[] arr) {
        // Write your code here
        Queue<Temp> queue = new LinkedList<Temp>();

        Node head = new Node(arr[0]);
        Node curr = head;
        queue.add(new Temp(head, Integer.MIN_VALUE, arr[0]));
        queue.add(new Temp(head, arr[0], Integer.MAX_VALUE));

        //  System.out.println("queue length >> "+ queue.size());
        for (int i = 1; i < arr.length; i++) {

            while (queue.size() > 0) {
                Temp t = queue.poll();
         /*  System.out.println("arr[i] >> "+ arr[i]);
           System.out.println("min >> "+t.min);
           System.out.println("max>> "+ t.max);*/
                Node d = new Node(arr[i]);
                //  Node l = null;
                if (arr[i] > t.min && arr[i] < t.max) {

                    if (arr[i] < t.parent.data) {
                        t.parent.left = d;
                        //  curr= curr.left;
                        //  d= t.parent.left;
                    } else {
                        t.parent.right = d;
                        //  curr.right = d;
                        //    curr = curr.right;
                        //  d = t.parent.right;
                    }
                    queue.add(new Temp(d, t.min, arr[i]));
                    queue.add(new Temp(d, arr[i], t.max));
                    break;
                }
            }

        }

        return head;

    }
}


class Temp {
    Node parent;
    int max;
    int min;

    Temp(Node p, int mi, int ma) {
        parent = p;
        max = ma;
        min = mi;
    }
}


