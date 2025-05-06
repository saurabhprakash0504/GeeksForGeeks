package com.binarySearchTree;

public class DeleteANodeInBST {

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(10);
        root.right = new Node(70);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        int x = 50;

        root = deleteANode(root, x);
        inorder(root);
    }


    static Node deleteANode(Node root, int x) {
        if (root == null) {
            return null;
        } else if (x > root.data) {
            root.right = deleteANode(root.right, x);
        } else if (x < root.data) {
            root.left = deleteANode(root.left, x);
        } else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            else {
                Node right = root.right;
                Node left = findLeftMost(right);
                root.data = left.data;
                root.right = deleteANode(root.right, left.data);
            }

        }
        return root;
    }

    private static Node findLeftMost(Node root) {

        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}

