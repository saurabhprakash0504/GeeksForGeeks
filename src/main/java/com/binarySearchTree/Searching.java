package com.binarySearchTree;

public class Searching {

    public static void main(String[] args) {
        Node tree = new Node(30);
        tree.left = new Node(20);
        tree.right = new Node(40);
        tree.right.left = new Node(35);
        tree.right.right = new Node(50);

        System.out.println(searchIterative(tree, 50));
        System.out.println(search(tree, 50));

    }


    static boolean search(Node root, int x) {
        if (root == null) {
            return false;
        }

        if (root.data == x) {
            return true;
        }

        if (x < root.data) {
            return search(root.left, x);
        } else
            return search(root.right, x);
    }


    static boolean searchIterative(Node root, int x){

        while (root != null){
            if(root.data == x){
                return true;
            }
            if(x < root.data){
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return false;
    }

}
