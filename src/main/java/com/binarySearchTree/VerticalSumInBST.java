package com.binarySearchTree;

import java.util.HashMap;
import java.util.TreeMap;

public class VerticalSumInBST {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);

        TreeMap<Integer, Integer> map = new TreeMap<>();

        findVerticalSum(root, 0, map);

        System.out.println(map.values());


    }

    static void findVerticalSum(Node root, int verticalLine, TreeMap<Integer, Integer> map){
        if(root == null){
            return;
        }

        if(map.containsKey(verticalLine)){
            int val = map.get(verticalLine);
            map.put(verticalLine, val+root.data);
        }else {
            map.put(verticalLine, root.data);
        }

        findVerticalSum(root.left, verticalLine-1, map);
        findVerticalSum(root.right, verticalLine+1, map);

    }
}
