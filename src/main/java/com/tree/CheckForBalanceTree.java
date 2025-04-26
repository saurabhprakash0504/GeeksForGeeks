package com.tree;

public class CheckForBalanceTree {

    public static void main(String[] args) {
        Node tree = new Node(3);
        tree.left = new Node(4);
        tree.right = new Node(5);
        tree.left.left = new Node(6);
      //  tree.left.left.left = new Node(7);
        tree.left.right = new Node(7);
        tree.right.right = new Node(8);
        tree.right.right.left = new Node(9);
        tree.right.right.left.left = new Node(10);

        System.out.println(isBalanceTree(tree));
    }

    static boolean isBalanceTree(Node root) {

        if (root == null) {
            return true;
        }

        int left =  findHeight(root.left);
        int right = findHeight(root.right);

        if (left == -1 || right == -1 ) {
            return false;
        } else {
            return true;
        }


    }

    private static int findHeight(Node root) {

        if (root == null) {
            return 0;
        }

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        if(left == -1 || right == -1){
            return -1;
        }

        if (Math.abs(left - right) <= 1) {
            return 1 + Integer.max(left, right);
        }else {
            return -1;
        }

    }
}
