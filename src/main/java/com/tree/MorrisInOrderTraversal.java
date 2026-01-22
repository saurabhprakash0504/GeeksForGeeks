package com.tree;

import java.util.ArrayList;

public class MorrisInOrderTraversal {

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

        MorrisInOrderTraversal obj = new MorrisInOrderTraversal();
        obj.morrisTraversal(tree, al);

        System.out.println(al);

    }

    //YT- Take U forward
    void morrisTraversal(Node root, ArrayList<Integer> al) {

        Node curr = root;
        while (curr != null) {

            //IF LEFT IS NOT NULL
            if (curr.left != null) {
                Node temp = curr.left;
                while (temp != null && temp.right != null && temp.right != curr) {

                    temp = temp.right;

                }
                //TO CREATE LINK
                if (temp.right == null) {
                    temp.right = curr;

                    curr = curr.left;
                }
                //TO REMOVE LINK && ADD CURR VALUE
                else {
                    temp.right = null;
                    al.add(curr.data);
                    curr = curr.right;
                }

            }
            //IF LEFT IS NULL
            else {
                al.add(curr.data);
                curr = curr.right;
            }

        }

    }
}
