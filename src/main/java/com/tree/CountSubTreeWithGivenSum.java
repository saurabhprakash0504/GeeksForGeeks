package com.tree;

public class CountSubTreeWithGivenSum {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(-10);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(8);
        root.right.right = new Node(7);
        root.right.left = new Node(-4);

        countSubtreesWithSumX(root, 7);

        System.out.println("total >> "+ total);
    }

    static int countSubtreesWithSumX(Node root, int X) {
        // Add your code here.
        count(root, X);
        return total;
    }

    static int total =0;
    static int count(Node root, int x){
        if(root == null){
            return 0;
        }

        int left = count(root.left, x);
        int right = count(root.right,x);
        if((root.data+ left+ right == x)){
            total++;
        }

        return root.data+left+right;
    }
}
