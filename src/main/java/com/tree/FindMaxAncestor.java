package com.tree;

import java.util.ArrayList;

public class FindMaxAncestor {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        //    root.right.right = new Node(7);
      /*  root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.left = new Node(10);*/

        int diff = maxDiff(root);

        System.out.println("diff >> " + max);


    }

    static int max = Integer.MIN_VALUE;

    static int maxi(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int left = maxi(root.left);



        int right = maxi(root.right);



        if (left != Integer.MAX_VALUE)
            max = Integer.max(max, root.data - left);

        if(right != Integer.MAX_VALUE)
            max = Integer.max(max, root.data - right);

        //  System.out.println("max >> "+max);

        return Integer.min(Integer.min(left, right), root.data);
    }

    static int maxDiff(Node root) {
        // your code here

        maxi(root);

        // System.out.println("max >> "+max);
        return max;
    }

}
