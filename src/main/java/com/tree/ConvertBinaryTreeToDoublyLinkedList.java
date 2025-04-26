package com.tree;

public class ConvertBinaryTreeToDoublyLinkedList {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        Node start = createDoublyLinkedList(root);
        printlist(start);
    }

    static Node prev = null;
    static Node start = null;

    static Node createDoublyLinkedList(Node root) {
        if (root == null) {
            return root;
        }
        createDoublyLinkedList(root.left);
        if (prev == null) {
            start = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        createDoublyLinkedList(root.right);
        return start;
    }

    public static void printlist(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }
}
