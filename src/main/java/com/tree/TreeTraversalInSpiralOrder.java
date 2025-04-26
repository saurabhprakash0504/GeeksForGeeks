package com.tree;

import java.util.*;

public class TreeTraversalInSpiralOrder {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(5);
        tree.right = new Node(20);
        tree.left.left = new Node(31);
        tree.left.right = new Node(32);
        tree.right.left = new Node(30);
        tree.right.right = new Node(33);
        tree.right.right.left = new Node(40);
        tree.right.right.right = new Node(41);
        //    printSpiralTreeTraversal(tree, 0);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getKey() % 2 == 0) {
                for (int i = 0; i <= entry.getValue().size() - 1; i++) {
                    System.out.print(entry.getValue().get(i) + " ");
                }
            } else {
                for (int i = entry.getValue().size() - 1; i >= 0; i--) {
                    System.out.print(entry.getValue().get(i) + " ");
                }
            }
        }

        System.out.println("second method");
        spiralTreePrintingIterative(tree);

    }


    static HashMap<Integer, List<Integer>> map = new HashMap<>();

    static void printSpiralTreeTraversal(Node root, int level) {

        if (root == null) {
            return;
        }

        printSpiralTreeTraversal(root.left, level + 1);
        printSpiralTreeTraversal(root.right, level + 1);

        if (map.containsKey(level)) {
            List<Integer> list = map.get(level);
            list.add(root.data);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(level, list);
        }
    }


    static void spiralTreePrintingIterative(Node node) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        if (node != null) {
            s1.add(node);
        }

        while (!s1.isEmpty() || !s2.empty()) {

            if (!s1.isEmpty()) {
                while (!s1.isEmpty()) {
                    Node curr = s1.pop();
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        s2.push(curr.left);
                    }
                    if (curr.right != null) {
                        s2.push(curr.right);
                    }
                }
            }

            if (!s2.isEmpty()) {
                while (!s2.isEmpty()) {
                    Node curr = s2.pop();
                    System.out.print(curr.data + " ");
                    if (curr.right != null) {
                        s1.push(curr.right);
                    }
                    if (curr.left != null) {
                        s1.push(curr.left);
                    }
                }
            }
        }
    }
}
