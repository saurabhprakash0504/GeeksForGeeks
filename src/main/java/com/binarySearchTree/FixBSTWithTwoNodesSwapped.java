package com.binarySearchTree;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FixBSTWithTwoNodesSwapped {

    public static void main(String[] args) {
    /*    Node root = new Node(20);
        root.left = new Node(60);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right = new Node(80);
        root.right.left = new Node(8);
        root.right.right = new Node(100);*/


        Node root = new Node(60);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right = new Node(80);
        root.right.left = new Node(20);
        root.right.right = new Node(100);

      //  fixBST(root);

        fixBST2(root);

        System.out.println("tree");

        swapNodeValue(first, second);

        System.out.println("after swap");
    }

    private static void swapNodeValue(Node first, Node second) {

        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }


    static void fixBST(Node tree) {

        int first = 0;
        int second = 0;
        ArrayList<Integer> al = new ArrayList<>();
        inOrderTraversal(tree, al);

        for (int i = 1; i < al.size(); i++) {
            if (al.get(i - 1) > al.get(i) && first == 0) {
                first = i - 1;
                second = i;
            } else if (al.get(i - 1) > al.get(i) && first != 0) {
                second = i;
                break;
            }


        }
        swap(al, first, second);

        System.out.println(al);

    }

    static Node prev = null;
    static Node first = null;
    static Node second = null;

    static void fixBST2(Node root) {

        if(root == null){
            return;
        }

        fixBST2(root.left);

        if (prev != null && root.data < prev.data) {

            if(first == null){
                first = prev;
                second = root;
            }else {
                second = prev;
            }

        }

        prev = root;

        fixBST2(root.right);

    }

    private static void swap(ArrayList<Integer> al, int first, int second) {

        int firstElement = al.get(first);
        int secondElement = al.get(second);
        al.set(second, firstElement);
        al.set(first, secondElement);
    }


    static void inOrderTraversal(Node root, ArrayList<Integer> al) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, al);
        al.add(root.data);
        inOrderTraversal(root.right, al);

    }
}
