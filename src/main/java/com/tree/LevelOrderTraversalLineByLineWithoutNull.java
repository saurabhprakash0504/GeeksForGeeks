package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLineWithoutNull {

    public static void main(String[] args) {
        Node tree = new Node(12);
        tree.left = new Node(8);
        tree.left.left = new Node(5);
        tree.left.right = new Node(11);
        tree.left.right.left = new Node(20);
        tree.right = new Node(18);

        printLevelOrder(tree);
    }

    static void printLevelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();

        if (root != null){
            queue.add(root);
        }

        while (!queue.isEmpty()){

           int length = queue.size();

            for(int i=0;i< length;i++){
                Node curr = queue.poll();
                System.out.print(curr.data +" ");
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    queue.add(curr.right);
                }
            }
            System.out.println();
        }

    }
}
