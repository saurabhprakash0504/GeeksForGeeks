package com.tree;

import java.util.*;

public class CountNodesAtDisKFromLeaf {

    public static void main(String[] args) {

        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        tree.right.left.right = new Node(8);

        /*Node tree = new Node(1);
        tree.left = new Node(3);
        //tree.right = new Node(3);
        tree.left.left = new Node(5);
        tree.left.left.left = new Node(7);
        tree.left.left.right = new Node(8);
        tree.left.left.right.right = new Node(9);*/
      //  tree.right.left.right = new Node(8);

        System.out.println(printKDistantfromLeaf(tree, 2));
    }

   /* static int ctr;
    static boolean visited[] = new boolean[100001];

    static void kDistantFromLeafUtil(Node root, int len, int k) {
        //base case
        if (root == null) return;

        visited[len] = false;
        len++;

        //if itâ€™s a leaf node, we increment the count but only if the
        //same ancestor at distance k is not already counted.
        if (root.left == null && root.right == null &&
                len - k - 1 >= 0 && visited[len - k - 1] == false) {
            ctr++;
            //setting the ancestor as visited so that we won't count it again.
            visited[len - k - 1] = true;
            return;
        }

        //if the current node is not a leaf node then we call the function
        //recursively for left and right subtrees.
        kDistantFromLeafUtil(root.left, len, k);
        kDistantFromLeafUtil(root.right, len, k);

    }

    //Function to return count of nodes at a given distance from leaf nodes.
    public static int printKDistantfromLeaf(Node root, int k) {
        ctr = 0;
        Arrays.fill(visited, false);

        kDistantFromLeafUtil(root, 0, k);
        //returning the count.
        return ctr;
    }*/


    //OWN METHOD
    static HashSet<Node> set = new HashSet<>();

    public static int printKDistantfromLeaf(Node root, int k) {

        if (root == null) {
            return 0;
        }
        List<Node> stack = new ArrayList<>();
        printKDistantfromLeaf(root, k, stack);
        System.out.println(Arrays.toString(set.toArray()));
        return set.size();

    }

    public static void printKDistantfromLeaf(Node root, int k, List<Node> list) {

        if (root == null) {
            return;
        }

        list.add(root);

        if (root.left == null && root.right == null && list.size() -1 >= (k)) {
            set.add(list.get(list.size() - 1 - (k)));
            list.remove(list.size() - 1);
            return;
        }

        printKDistantfromLeaf(root.left, k, list);
        list.remove(root.left);
        printKDistantfromLeaf(root.right, k, list);
        list.remove(root.right);

    }
}



