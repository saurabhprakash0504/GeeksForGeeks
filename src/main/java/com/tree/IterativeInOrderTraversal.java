package com.tree;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeInOrderTraversal {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.left.right = new Node(50);
        tree.left.right.right = new Node(60);
        tree.right = new Node(30);
        tree.left.left = new Node(40);

        inOrderVideo(tree);
        System.out.println();
        iterative(tree);
        // iterative(tree);
    }


    static void inOrderVideo(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.peek();
            if (curr.right != null)
                stack.push(curr.right);
            curr = stack.pop();
            System.out.print(curr.data + " ");
            if (curr.left != null)
                stack.push(curr.left);
        }
    }


    static void iterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data +" ");
            curr = curr.right;
        }
    }
}
