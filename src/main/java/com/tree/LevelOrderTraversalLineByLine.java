package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {

    public static void main(String[] args) {
        Node tree = new Node(12);
        tree.left = new Node(8);
        tree.left.left = new Node(5);
        tree.left.right = new Node(11);
        tree.right = new Node(18);

        printLevelOrder(tree);
    }

    static void printLevelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        if (root != null){
            queue.add(root);
            queue.add(null);
        }
        while (!queue.isEmpty()){

            Node curr = queue.poll();

            if (curr == null){
                System.out.println();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }
            else {
                System.out.print(curr.data + " ");
                if(curr.left != null){
                    queue.add(curr.left);
                } if(curr.right != null){
                    queue.add(curr.right);
                }
            }

        }

    }
}
