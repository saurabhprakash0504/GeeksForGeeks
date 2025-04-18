package com.tree;

public class MaxInABinaryTree {
    public static void main(String[] args) {
        Node tree = new Node(12);
        tree.left = new Node(8);
        tree.left.left = new Node(5);
        tree.left.right = new Node(11);
    //    tree.left.right.left = new Node(20);
    //    tree.left.right.right = new Node(22);
        tree.right = new Node(18);

      //  sizeOfATree(tree);
        System.out.println("max >> " + findMax(tree));
    }

    static int findMax(Node root){
        if (root == null){
            return Integer.MIN_VALUE;
        }

        return Integer.max(Integer.max(findMax(root.left),findMax(root.right)),root.data);
    }
}
