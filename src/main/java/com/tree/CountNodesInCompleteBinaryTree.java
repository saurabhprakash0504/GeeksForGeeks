package com.tree;

public class CountNodesInCompleteBinaryTree {

    public static void main(String[] args) {
        Node tree = new Node(3);
        tree.left = new Node(4);
        tree.right = new Node(5);
        tree.left.left = new Node(6);
        tree.left.right = new Node(7);
        tree.right.right = new Node(8);
        tree.right.left = new Node(9);
        tree.left.left.left = new Node(10);
        tree.left.left.left.left = new Node(11);
        System.out.println("naive way "+countNodesNaive(tree));
        System.out.println("finding size "+countNodes(tree));
    }

    static int countNodesNaive(Node root) {

        if (root == null) {
            return 0;
        }

        return 1 + countNodesNaive(root.left) + countNodesNaive(root.right);

    }

    static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        Node left = root.left;
        int leftSize = 1;
        while (left != null) {
            leftSize++;
            left = left.left;
        }

        Node right = root.right;
        int rightSize = 1;
        while (right != null) {
            rightSize++;
            right = right.right;
        }

        if (leftSize == rightSize) {
            return (int) Math.pow(2, rightSize) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }
}
