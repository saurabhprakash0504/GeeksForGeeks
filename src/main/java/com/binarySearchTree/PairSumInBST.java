package com.binarySearchTree;

import java.util.HashSet;

public class PairSumInBST {

    public static void main(String[] args) {
 /*       Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(11);
        root.right.right = new Node(30);
        root.right.right.left = new Node(25);

        isSum(root, 33);*/

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(40);
        root.right.left = new Node(35);

        System.out.println(isSum(root, 49));
        //  System.out.println(flag);
    }

    // static boolean flag = false;
    static boolean isSum(Node root, int total) {
        if (root == null) {
            return false;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        return findPair(root, hashSet, total);
    }

    static boolean findPair(Node root, HashSet<Integer> hashSet, int total) {
        if (root == null) {
            return false;
        }

        //  findPair(root.left, hashSet, total);
        if (hashSet.contains(total - root.data)) {
            return true;
        } else {
            hashSet.add(root.data);
        }

        return findPair(root.left, hashSet, total) || findPair(root.right, hashSet, total);
    }
}
