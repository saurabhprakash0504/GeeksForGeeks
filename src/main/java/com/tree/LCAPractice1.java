package com.tree;

public class LCAPractice1 {


    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);

        System.out.println(lca(tree, 4, 5).data);
    }

    static Node lca(Node root, int n1, int n2) {
        // code here
        if (root == null) {
            return root;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }


        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (right == null && left != null) {
            return left;
        } else {
            return null;
        }

    }
}
