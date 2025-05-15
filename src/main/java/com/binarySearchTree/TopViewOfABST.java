package com.binarySearchTree;

import java.util.TreeMap;

public class TopViewOfABST {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(50);
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        printTopView(root);
    }

    static void printTopView(Node root){
        if(root == null){
            return;
        }

        TreeMap<Integer,Integer> map = new TreeMap<>();
        topView(root,0, map);

        System.out.println(map.values());

    }

    static void topView(Node root, int horizontalDis, TreeMap<Integer, Integer> map){
        if(root == null){
            return;
        }

        if(!map.containsKey(horizontalDis)){
            map.put(horizontalDis, root.data);
        }

        topView(root.left, horizontalDis-1, map);
        topView(root.right, horizontalDis+1, map);

    }
}
