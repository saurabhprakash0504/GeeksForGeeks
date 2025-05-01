package com.tree;

import java.util.*;

public class LevelOrderTraversals {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(4);
        //tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(2);
       // tree.right.left = new Node(6);
       // tree.right.right = new Node(7);
       // tree.right.left.right = new Node(8);
        ArrayList<ArrayList<Integer>> list = levelOrder(tree);
        System.out.println("list << "+ list);
    }

    static ArrayList<ArrayList<Integer>> levelOrder(Node node) {
        // Your code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (node != null) {
            check(node, list);
        }
        return list;
    }

    static void check(Node node, ArrayList<ArrayList<Integer>> list) {

        Queue<Node> queue = new LinkedList<Node>();
        ArrayList<Integer> l = new ArrayList<Integer>();
        queue.add(node);
      //  l.add(node.data);
        queue.add(null);
        while (queue.size() > 1) {
            Node val = queue.poll();
          //  queue.remove(0);
            if (val == null) {
                queue.add(null);
                list.add(l);
                l = new ArrayList<Integer>();
            } else {
                l.add(val.data);
                if (val.left != null) {
                    queue.add(val.left);
                }
                if (val.right != null) {
                    queue.add(val.right);
                }
            }

        }
        list.add(l);
    }
}
