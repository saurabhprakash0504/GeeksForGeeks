package com.tree;

import java.util.*;

public class DistanceBetween2Nodes {

    public static void main(String[] args) {

        DistanceBetween2Nodes dbn = new DistanceBetween2Nodes();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int a = 4;
        int b = 5;

        int dist = dbn.findDist(root, a, b);
        System.out.println("Distance between " + a + " and " + b + " is: " + dist);

    }

    int findDist(Node root, int a, int b) {
        // Your code here
        Node node = lca(root, a, b);
        //  System.out.println("node data" + node.data);
        Node curr1 = node;
         /*  Node curr2 = node;
           int d1 = distance(curr1, a);
           int d2 = distance(curr2, b);

           return d1 + d2;*/

        return distance2(curr1, a, b);

        //  return 1;
    }

    int distance2(Node node, int a, int b) {
        int d1 = 0;
        boolean foundOne = false;
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        q.add(null);
        int d = 0;
        while (q.size() > 1) {

            Node p = q.poll();
            if (p == null) {
                d++;
                q.add(null);
            } else {
                if ((p.data == a || p.data == b) && foundOne == false) {
                    d1 = d;
                    foundOne = true;
                } else if ((p.data == a || p.data == b) && foundOne == true) {
                    d1 = d1 + d;
                    return d1;
                }
                Node l = p.left;
                if (l != null) {
                    q.add(l);
                }
                Node r = p.right;
                if (r != null) {
                    q.add(r);
                }
            }
        }
        return d1;
    }

      /*  int distance(Node node, int a){
            int d = 0;
            Queue<Node> q = new LinkedList<Node>();
            q.add(node);
            q.add(null);
            while(!q.isEmpty()){

                Node p = q.poll();
                if(p == null){
                    d++;
                    q.add(null);
                }

                else if (p.data == a){
                    break;
                }else{
                    Node l = p.left;
                    if(l != null){
                        q.add(l);
                    }
                    Node r = p.right;
                    if(r != null){
                        q.add(r);
                    }
                }
            }
            return d;
        }*/

    Node lca(Node root, int a, int b) {

        if (root == null) {
            return null;
        }

        if (root.data == a || root.data == b) {
            return root;
        }

        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a, b);

        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }

    }
}
