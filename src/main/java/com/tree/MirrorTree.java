package com.tree;

public class MirrorTree {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);

        mirror(tree);
        System.out.println("after");
    }

    static void mirror(Node node) {
        // Your code here

        mirror1(node);


    }

    static Node mirror1(Node root){
        if(root == null){
            return root;
        }

        Node left = mirror1(root.left);
        Node right = mirror1(root.right);
        root.left = right;
        root.right = left;

        return root;
    }
}
