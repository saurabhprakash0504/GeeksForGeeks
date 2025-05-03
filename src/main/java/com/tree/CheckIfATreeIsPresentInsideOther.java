package com.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CheckIfATreeIsPresentInsideOther {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //  int t=Integer.parseInt(br.readLine());
        // while(t-- > 0){
        String tt = "1 2 3 N N 4";
        Node rootT = buildTree(tt);

        String s = "3 4";
        Node rootS = buildTree(s);
        // printInorder(root);

        // Solution tr=new Solution();
        boolean st = isSubtree(rootT, rootS);
        if (st == true) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        System.out.println("~");
    }

    public static boolean isSubtree(Node t, Node s) {
        // add code here.

        if (s == null) {
            return true;
        }
        if (t == null) {
            return false;
        }

        //IMP
        if (compare(t, s)) {
            return true;
        }

        return isSubtree(t.left, s) || isSubtree(t.right, s);
    }


    static boolean compare(Node t, Node s) {

        if (t == null && s == null) {
            return true;
        }

        if ((t == null && s != null) || (s == null && t != null)) {
            return false;
        }
        if (t.data != s.data) {
            return false;
        }

        return compare(t.left, s.left) && compare(t.right, s.right);
    }

}

