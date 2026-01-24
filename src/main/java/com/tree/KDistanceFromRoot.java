package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KDistanceFromRoot {

    public static void main(String[] args) {

        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.left.left = new Node(40);
        tree.left.right = new Node(50);
        tree.left.right.left = new Node(70);
        tree.left.right.right = new Node(80);
        tree.right = new Node(30);
        tree.right.right = new Node(60);

        int k = 2;

        KDistanceFromRoot obj = new KDistanceFromRoot();
        ArrayList<Integer> al = obj.Kdistance(tree, k);

        System.out.println(al);
    }

    ArrayList<Integer> Kdistance(Node root, int k) {
        // Your code here
        Queue<Node> q = new LinkedList<>();
        int dis = 0;
        q.add(root);
        q.add(null);
        ArrayList<Integer> al = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp == null) {

                if (dis == k) {
                    return al;
                }
                dis++;
                al = new ArrayList<>();
                q.add(null);
            } else {
                al.add(temp.data);
                Node left = temp.left;
                Node right = temp.right;
                if (left != null) {
                    q.add(left);
                }
                if (right != null) {
                    q.add(right);
                }
            }

        }
        //System.out.println("al >> "+ al);
        return al;
    }
}
