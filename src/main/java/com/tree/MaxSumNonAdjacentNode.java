package com.tree;

import java.util.*;

public class MaxSumNonAdjacentNode {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(9);
        //   tree.left.left = new Node(4);

        tree.right = new Node(8);
        tree.left.left = new Node(5);
        tree.left.right = new Node(10);
        //  tree.right.left = new Node(5);
        // tree.right.right = new Node(5);
        int sum = getMaxSum(tree);
        System.out.println("sum " + sum);
    }

    static LinkedHashMap<Node, Integer> map = new LinkedHashMap<Node, Integer>();

    public static int getMaxSum(Node root) {

        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int curr = 0;
        curr = curr + root.data;
        if (root.left != null) {

            int val = getMaxSum(root.left.left);

            // map.put(root.left.left, val);
            curr = curr + val;
            // }
        }
        if (root.left != null) {
            curr = curr + getMaxSum(root.left.right);
        }
        if (root.right != null) {
            curr = curr + getMaxSum(root.right.left);
        }
        if (root.right != null) {
            curr = curr + getMaxSum(root.right.right);
        }

        int child = 0;
        //  if(root.left!=null){
        child = child + getMaxSum(root.left);
        //  }

        //  if(root.right != null){
        child = child + getMaxSum(root.right);
        //  }

        map.put(root, Integer.max(curr, child));

        return Integer.max(curr, child);
    }
}