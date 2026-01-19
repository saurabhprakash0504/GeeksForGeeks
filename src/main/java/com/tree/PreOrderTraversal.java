package com.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.left.left = new Node(40);
        tree.left.right = new Node(50);
        tree.left.right.left = new Node(70);
        tree.left.right.right = new Node(80);
        tree.right = new Node(30);
        tree.right.right = new Node(60);

        //preOrderTraversal(tree);

        ArrayList<Integer> al = new ArrayList<>();

        findIterative(tree, al);

        System.out.println(al);

    }

    static void preOrderTraversal(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void findIterative(Node root, ArrayList<Integer> al){

        Stack<Node> stack = new Stack<Node>();

        Node curr = root;
        while(curr != null || !stack.isEmpty() ){
            while(curr != null){
                stack.push(curr);
                al.add(curr.data);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
    }
}
