package com.binarySearchTree;

public class InsertInBST {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(2);
        tree.left.left = new Node(1);
        tree.right = new Node(30);


        //insertRecurssive(tree, 5);
        iterativeInsert(tree, 5);

        System.out.println("root");

    }

    static Node insertRecurssive(Node root, int val) {
        if (root == null) {
            //Node temp = new Node(val);
            //root = temp;
            return new Node(val);
        }
        if (root.data == val) {
            return root;
        }
        if (val < root.data) {
            root.left = insertRecurssive(root.left, val);
            //root.left = new Node(val);
        }

        if (val > root.data) {
            root.right = insertRecurssive(root.right, val);
            // root.right = new Node(val);
        }

        return root;

    }


    static Node iterativeInsert(Node root, int val) {

        Node prev = null;
        Node curr = root;

        while (curr != null) {
            if (val < root.data) {
                prev = curr;
                curr = curr.left;
            } else if (val > root.data) {
                prev = curr;
                curr = curr.right;
            }else {
                return root;
            }


        }

        Node temp = new Node(val);
        if(prev == null){
            return temp;
        }
        if (val < prev.data) {
            prev.left = temp;
        } else {
            prev.right = temp;
        }

        return root;

    }
}
