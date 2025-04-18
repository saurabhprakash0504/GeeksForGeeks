package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        Node tree = new Node(12);
        tree.left = new Node(8);
        tree.left.left = new Node(5);
        tree.left.right = new Node(11);
        tree.right = new Node(18);

        printLevelOrder(tree);
    }

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }
}
