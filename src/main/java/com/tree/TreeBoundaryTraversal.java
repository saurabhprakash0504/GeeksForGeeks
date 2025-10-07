package com.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class TreeBoundaryTraversal {

    LinkedHashSet<Integer> hs = new LinkedHashSet<>();

    ArrayList<Integer> boundaryTraversal(Node node) {

        // code here
        if (node == null) {
            return new ArrayList<Integer>();
        }
        hs.add(node.data);

        //  LinkedHashMap<Integer,Integer> m1 = new LinkedHashMap<>();
        ArrayList<Integer> l1 = leftSide(node.left);
        //  List<Integer> l1 = new ArrayList<>(m1.values());

        //  Collections.reverse(l1);
        for (int i : l1) {
            hs.add(i);
        }
        // System.out.println("hs1 >> "+ hs);

        bottom(node);
        //  LinkedHashMap<Integer,Integer> m3 = new LinkedHashMap<>();
        ArrayList<Integer> l3 = rightSide(node.right);
        // List<Integer> l = new ArrayList<>(m3.values());

        Collections.reverse(l3);
        for (int i : l3) {
            hs.add(i);
        }
        ArrayList<Integer> al = new ArrayList<Integer>(hs);

        return al;
    }

    ArrayList<Integer> leftSide(Node node) {
        ArrayList<Integer> al = new ArrayList<>();
        if (node == null) {
            //        rightMost = true;
            return al;
        }


        while (node != null) {
            al.add(node.data);
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return al;
    }


    void bottom(Node node) {

        if (node != null && node.left == null && node.right == null) {
            //  System.out.println("hs >> "+ hs);
            hs.add(node.data);
        }
        if (node != null)
            bottom(node.left);
        if (node != null)
            bottom(node.right);

    }

    //  boolean rightMost = false;
    ArrayList<Integer> rightSide(Node node) {
        ArrayList<Integer> al = new ArrayList<>();
        if (node == null) {
            //        rightMost = true;
            return al;
        }


        while (node != null) {
            al.add(node.data);
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return al;
    }

}

