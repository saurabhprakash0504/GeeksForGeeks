package com.tree;

import java.util.ArrayList;
import java.util.Collections;

public class MorrisPostOrderTraversal {

    public static void main(String[] args) {

        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.left.left = new Node(40);
        tree.left.right = new Node(50);
        tree.left.right.left = new Node(70);
        tree.left.right.right = new Node(80);
        tree.right = new Node(30);
        tree.right.right = new Node(60);

        ArrayList<Integer> al = new ArrayList<>();

        MorrisPostOrderTraversal obj = new MorrisPostOrderTraversal();
        obj.morrisTraversal(tree, al);

        System.out.println(al);

    }

    void morrisTraversal(Node root, ArrayList<Integer> al){

        Node curr = root;

        while (curr != null) {

            // IF RIGHT IS NOT NULL (mirror of your left logic)
            if (curr.right != null) {

                Node temp = curr.right;
                while (temp.left != null && temp.left != curr) {
                    temp = temp.left;
                }

                // CREATE LINK & ADD VALUE
                if (temp.left == null) {
                    al.add(curr.data);      // still add on first visit
                    temp.left = curr;       // thread on LEFT instead of RIGHT
                    curr = curr.right;      // go RIGHT first
                }
                // REMOVE LINK
                else {
                    temp.left = null;
                    curr = curr.left;       // then go LEFT
                }
            }
            // IF RIGHT IS NULL
            else {
                al.add(curr.data);
                curr = curr.left;
            }
        }

        // FINAL STEP: reverse to convert root→right→left into postorder
        Collections.reverse(al);
    }

}
