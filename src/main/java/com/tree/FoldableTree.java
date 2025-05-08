package com.tree;

import java.util.ArrayList;

public class FoldableTree {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(7);
        tree.right = new Node(15);
        tree.left.left = new Node(10);
        tree.left.right = new Node(9);
        tree.right.right = new Node(12);
        System.out.println(IsFoldable(tree));
    }

    static boolean IsFoldable(Node node) {

        if(node == null){
            return  true;
        }

        return isFoldable(node.left, node.right);
    }

    static boolean isFoldable(Node n1 , Node n2){
        if(n1== null && n2 == null){
            return true;
        }

        else if((n1 == null && n2 != null) || (n2== null && n1!= null)){
            return false;
        }
        else if(n1 != null && n2!=null){
            if ((n1.left == null && n2.right != null) || (n1.right == null && n2.left != null)){
                return false;
            }
        }

        return (isFoldable(n1.left, n2.right) && isFoldable(n1.right, n2.left));
    }
}
