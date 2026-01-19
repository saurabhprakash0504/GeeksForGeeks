package com.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversalIterativeApproach {

    public static void main(String[] args) {

        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.left.left = new Node(40);
        tree.left.right = new Node(50);
        tree.left.right.left = new Node(70);
        tree.left.right.right = new Node(80);
        tree.right = new Node(30);
        tree.right.right = new Node(60);

        //postOrderTraversal(tree);

        ArrayList<Integer> al = new ArrayList<>();

        PostOrderTraversalIterativeApproach obj = new PostOrderTraversalIterativeApproach();
        obj.findIterative(tree, al);

        System.out.println(al);

    }

    //YT - Take U forward
    //2 stacks
    void findIterative(Node root, ArrayList<Integer> al) {

        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();

        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node pop = stack1.pop();
            stack2.push(pop);
            if (pop.left != null) {
                stack1.push(pop.left);
            }

            if (pop.right != null) {
                stack1.push(pop.right);
            }
        }

        while (!stack2.isEmpty()) {
            al.add(stack2.pop().data);
        }

    }
}
