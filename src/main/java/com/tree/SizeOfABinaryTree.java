package com.tree;

public class SizeOfABinaryTree {
    public static void main(String[] args) {
        Node tree = new Node(12);
        tree.left = new Node(8);
        tree.left.left = new Node(5);
        tree.left.right = new Node(11);
        tree.left.right.left = new Node(20);
        tree.left.right.right = new Node(22);
        tree.right = new Node(18);

        sizeOfATree(tree);
        System.out.println("size " + size);
        System.out.println("size second method  >> " + sizeOfATrees(tree));

    }

    static int size = 0;

    static void sizeOfATree(Node root) {
        if (root == null) {
            return;
        }
        sizeOfATree(root.left);
        size++;
        sizeOfATree(root.right);
    }

    static int sizeOfATree(Node root, int size) {

        if (root == null) {
            return 0;
        }
        sizeOfATree(root.left, size);
        size++;
        sizeOfATree(root.right, size);
        return size;

    }


    static int sizeOfATrees(Node root) {

        if (root == null) {
            return 0;
        }
        return 1+ sizeOfATrees(root.left) + sizeOfATrees(root.right);


    }
}
