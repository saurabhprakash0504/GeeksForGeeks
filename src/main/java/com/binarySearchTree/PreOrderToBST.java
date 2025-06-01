package com.binarySearchTree;

import java.util.*;

public class PreOrderToBST {

    public static void main(String[] args) {
        int[] pre = {40,30,35,80,100};
       Node root = Bst(pre, pre.length);
        System.out.print("root "+ root);
    }

    static public Node Bst(int pre[], int size) {
        // code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=0;i<pre.length;i++){
            al.add(pre[i]);
        }

        Node root = Bsta(al);
        return root;

    }

   static Node Bsta(ArrayList<Integer> arr){
        if(arr.size() == 0){
            return null;
        }

        int val = arr.get(0);
        Node temp = new Node(val);

        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();

        for(int i=1;i<arr.size();i++){
            if(arr.get(i) < val){
                left.add(arr.get(i));
            }else{
                right.add(arr.get(i));
            }
        }

        temp.left = Bsta(left);
        temp.right = Bsta(right);

        return temp;

    }
}

