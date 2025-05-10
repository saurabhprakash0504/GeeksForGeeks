package com.binarySearchTree;

public class FindKthSmallestInBST {

    static BSTNode root = null;

    public static void main(String[] args) {

        insert(50);
        insert(20);
        insert(100);
        insert(10);
        insert(40);
        insert(70);
        insert(120);

        System.out.println("after Insert");

        int val = findKthSmallestElement(root, 8);

        System.out.println("val >> " + val);

    }


    private static int findKthSmallestElement(BSTNode root, int k) {

        if(root == null){
            return -1;
        }

        if ((root.leftSize + 1) == k) {
            return root.data;
        } else if (k < root.leftSize + 1) {
            return findKthSmallestElement(root.left, k);
        } else {

            return findKthSmallestElement(root.right, k - (root.leftSize + 1));
        }
    }

    static void insert(int data) {

        if (root == null) {
            root = new BSTNode(data);
            return;
        } else {

            BSTNode curr = root;
            BSTNode prev = null;

            while (curr != null) {
                if (data < curr.data) {
                    curr.leftSize++;
                    prev = curr;
                    curr = curr.left;
                } else {
                    prev = curr;
                    curr = curr.right;
                }
            }

            if (data < prev.data) {
                //  prev.leftSize++;
                prev.left = new BSTNode(data);
            } else {
                prev.right = new BSTNode(data);
            }


        }

    }
}


class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;
    int leftSize;

    BSTNode(int data) {
        this.data = data;
    }
}



