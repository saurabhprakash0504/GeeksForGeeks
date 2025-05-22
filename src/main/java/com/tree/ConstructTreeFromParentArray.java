package com.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeFromParentArray {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 0, 1, 1, 3, 5};

        Node node = createTree(arr);

        System.out.println("node " + node);

    }

    public static Node createTree(int parent[]) {
        // Your code here
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Queue<Node> queue = new LinkedList<>();
        Node root = null;
        for (int i = 0; i < parent.length; i++) {

            if (parent[i] == -1) {
                root = new Node(i);
                queue.add(root);
            } else {
                if (map.containsKey(parent[i])) {
                    ArrayList<Integer> al = map.get(parent[i]);
                    al.add(i);
                } else {
                    ArrayList<Integer> al = new ArrayList<Integer>();
                    al.add(i);
                    map.put(parent[i], al);
                }
            }
        }

        while (!queue.isEmpty()) {
            Node polled = queue.poll();

            if (map.containsKey(polled.data)) {
                ArrayList<Integer> al = map.get(polled.data);
                Node left = new Node(al.get(0));
                polled.left = left;
                queue.add(left);
                if (al.size() == 2) {
                    Node right = new Node(al.get(1));
                    polled.right = right;
                    queue.add(right);
                }
            }

        }
        return root;
    }
}
