package com.tree;

import java.util.ArrayList;

public class SearlizeAndDesearlize {

    public static void main(String[] args) {
        Node tree = new Node(3);
        tree.left = new Node(4);
        tree.right = new Node(5);
        tree.left.left = new Node(6);
        tree.left.right = new Node(7);
        tree.right.right = new Node(8);
        tree.right.right.left = new Node(9);
        tree.right.right.left.left = new Node(10);
        ArrayList<Integer> list = new ArrayList<>();
        searlize(tree, list);
        System.out.println(list);
        System.out.println("after inserting");
        Node node = desealize(list);
        preOrder(node);

    }

    static void searlize(Node root, ArrayList<Integer> list) {

        if (root == null) {
            list.add(-1);
            return;
        }

        list.add(root.data);
        searlize(root.left, list);
        searlize(root.right, list);

    }

    static int i = 0;

    static Node desealize(ArrayList<Integer> list) {
        if (list.size() == i - 1) {
            return null;
        }

        if (list.get(i) == -1) {
            i++;
            return null;
        }
        Node root = new Node(list.get(i));
        i++;
        root.left = desealize(list);
        root.right = desealize(list);
        return root;
    }


    static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

}
