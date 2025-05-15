package com.binarySearchTree;

import java.util.*;

public class VerticalTraversalOfBST {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.right.right.left = new Node(80);
        root.right.right.left.left = new Node(90);

        printVerticalTraversal(root);


    }

    static void printVerticalTraversal(Node root) {
        if (root == null) {
            return;
        }

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        getVerticalTraversal(root, 0, map);

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    static void getVerticalTraversal(Node root, int vertical, TreeMap<Integer, ArrayList<Integer>> map) {

        if (root == null) {
            return;
        }

        if (map.containsKey(vertical)) {
            ArrayList<Integer> al = map.get(vertical);
            al.add(root.data);
        } else {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(root.data);
            map.put(vertical, l);
        }

        getVerticalTraversal(root.left, vertical - 1, map);
        getVerticalTraversal(root.right, vertical + 1, map);

    }

}
