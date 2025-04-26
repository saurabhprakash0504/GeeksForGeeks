package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfATree {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.left.left = new Node(40);
        tree.left.right = new Node(50);
        tree.left.right.left = new Node(70);
        tree.left.right.left.right = new Node(90);
        tree.left.right.right = new Node(80);
        tree.right = new Node(30);
        tree.right.right = new Node(60);

        leftViewIterativeApproach(tree);
        System.out.println("rerurssive");
        printLeftViewRecurrsiveApproach(tree, 0);
    }

    static void leftViewIterativeApproach(Node root) {
        Queue<Node> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
            queue.add(null);
        }
        Node prev = null;
        while (queue.size() > 1) {

            Node curr = queue.poll();
            if (prev == null) {
                System.out.println(curr.data);
            }
            if (curr == null) {
                queue.add(null);
            } else {
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            prev = curr;
        }
    }

    static int maxLevel = -1;

    static void printLeftViewRecurrsiveApproach(Node root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.println(root.data);
            maxLevel = level;
        }

        printLeftViewRecurrsiveApproach(root.left, level + 1);
        printLeftViewRecurrsiveApproach(root.right, level + 1);
    }
}
