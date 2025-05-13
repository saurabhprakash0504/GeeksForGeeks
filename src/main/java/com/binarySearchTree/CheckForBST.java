package com.binarySearchTree;

public class CheckForBST {

    public static void main(String[] args) {
        Node tree = new Node(20);
        tree.left = new Node(8);
        tree.right = new Node(130);
        tree.right.left = new Node(22);

        System.out.println(isBST(tree));
        System.out.println(isBSTMethod2(tree));
      //  System.out.println(flag);

    }

    static boolean isBST(Node root) {
        return checkBST(root);
    }

    static boolean checkBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBST(Node node, int min, int max) {
        if (node == null) return true;

        if (node.data <= min || node.data >= max) return false;

        return isBST(node.left, min, node.data) &&
                isBST(node.right, node.data, max);
    }


    static int prev = Integer.MIN_VALUE;
    static boolean isBSTMethod2(Node root) {

        if (root == null) {
            return true;
        }

        isBSTMethod2(root.left);

        if (root.data < prev) {
            return false;
        } else {
            prev = root.data;
        }

       return isBSTMethod2(root.right);
    }
}
