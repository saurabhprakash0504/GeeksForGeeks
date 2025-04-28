package com.tree;

import java.util.Stack;

public class PreOrderTraversalIterative {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.right = new Node(30);
        tree.left.left = new Node(40);
        tree.left.right = new Node(50);
        tree.right.left = new Node(60);
        tree.left.left.left = new Node(70);
        tree.left.left.right = new Node(80);

        preOrder(tree);
        System.out.println();
        preOrderVideo(tree);

    }

    static void preOrder(Node root) {
        Stack<Node> stack = new Stack<>();

        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                System.out.print(curr.data + " ");
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
    }


    static void preOrderVideo(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
    }
}
