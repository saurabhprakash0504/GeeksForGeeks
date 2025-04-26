package com.tree;

public class RightViewOfATree {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.left.left = new Node(40);
        tree.left.right = new Node(50);
        tree.left.right.left = new Node(70);
        tree.left.right.left.right = new Node(90);
        tree.left.right.right = new Node(80);
        tree.right = new Node(30);
        tree.right.right = new Node(60);

        printRightViewUsingRecurssion(tree, 0);
    }

    static int maxLevel = -1;

    static void printRightViewUsingRecurssion(Node root, int level) {

        if (root == null) {
            return;
        }

        if (level > maxLevel) {
            System.out.println(root.data);
            maxLevel = level;
        }

        printRightViewUsingRecurssion(root.right, level + 1);
        printRightViewUsingRecurssion(root.left, level + 1);

    }
}
