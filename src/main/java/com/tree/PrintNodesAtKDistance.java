package com.tree;

public class PrintNodesAtKDistance {

    public static void main(String[] args) {

        Node tree = new Node(12);
        tree.left = new Node(8);
        tree.left.left = new Node(5);
        tree.left.right = new Node(11);
        tree.right = new Node(18);

        printNodes(tree, 2);
    }

    static void printNodes(Node root, int k) {

        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.println(root.data);
            return;
        }

        printNodes(root.left, k - 1);
        printNodes(root.right, k - 1);

    }
}
