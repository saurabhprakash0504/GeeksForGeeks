package com.binarySearchTree;

public class FloorInBST {

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(30);
        int x = 6;

        Node val = findFloor(root, x);
        Node valIterative = findFloorIterative(root, x);

        System.out.println(smallest);
        System.out.println("Iterative   " + valIterative.data);

    }

    static int smallest = Integer.MIN_VALUE;

    static Node findFloor(Node root, int x) {
        if (root.left == null || root.right == null) {
            return root;
        }


        if (root.data == x || (root.data < x && root.data > smallest)) {
            smallest = root.data;
            //  return root;
        }

        Node left = findFloor(root.left, x);
        if (left.data == x || (left.data < x && left.data > smallest)) {
            smallest = left.data;
            // return left;
        }


        Node right = findFloor(root.right, x);
        if (right.data == x || (right.data < x && right.data > smallest)) {
            smallest = right.data;
            // return right;
        }

        return root;

    }


    static Node findFloorIterative(Node root, int x) {
        Node small = null;
        while (root != null) {
            if (root.data == x) {
                small = root;
                return small;
            } else if (x < root.data) {
                root = root.left;
            } else if (x > root.data) {
                small = root;
                root = root.right;
            }
        }
        return small;
    }
}
