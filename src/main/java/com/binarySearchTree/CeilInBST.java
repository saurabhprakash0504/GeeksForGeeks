package com.binarySearchTree;

public class CeilInBST {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(30);
        int x = 3;

        Node valIterative = findCeil(root, x);

        System.out.println("Iterative   " + valIterative.data);

    }

    static Node findCeil(Node root, int x){

        Node ceil = null;

        while (root!= null){
            if(root.data == x){
                ceil = root;
                return root;
            }else if(root.data < x){
                root = root.right;
            }else{
                ceil  = root;
                root = root.left;
            }
        }

        return ceil;
    }
}
