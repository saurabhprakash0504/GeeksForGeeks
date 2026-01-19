package com.tree;

import java.util.Stack;

public class InOrderTraversal {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right = new Node(3);

        findIterative(tree);
    }

    static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);

    }


    static void findIterative(Node root) {

        Stack<Node> stack = new Stack<Node>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.println(curr.data);
            curr = curr.right;

        }


    }
}
