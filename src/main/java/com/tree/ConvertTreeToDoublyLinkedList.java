package com.tree;

public class ConvertTreeToDoublyLinkedList {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.right = new Node(15);
        tree.left.left = new Node(25);
        tree.left.right = new Node(30);
        tree.right.left = new Node(36);

       Node temp =  bToDLL(tree);

        System.out.println(temp);
    }


    static Node bToDLL(Node root) {
        bToDLL1(root);
        return head;
    }

    static Node head = null;
    static Node prev = null;

    static void bToDLL1(Node root) {

        if (root == null) {
            return;
        }

        bToDLL1(root.left);
        if (head == null) {
            head = root;
            prev = root;
        } else {
            prev.right = root;
            root.left = prev;
            prev = prev.right;
        }
        bToDLL1(root.right);
    }

}
