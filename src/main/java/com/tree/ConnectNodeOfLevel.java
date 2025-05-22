package com.tree;

import java.util.*;

public class ConnectNodeOfLevel {

    public static void main(String[] args) {

    }

    public Nodes connect(Nodes root) {
        // Your code goes here.
        Queue<Nodes> queue = new LinkedList<Nodes>();
        Queue<Nodes> queue1 = new LinkedList<Nodes>();
        queue.add(root);
        queue1.add(root);
        queue.add(null);
        queue1.add(null);
        while (queue.size() > 1) {
            Nodes node = queue.poll();
            if (node == null) {
                queue.add(null);
                queue1.add(null);
                continue;
            }

            if (node.left != null) {
                queue.add(node.left);
                queue1.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
                queue1.add(node.right);
            }
        }
        // System.out.println("node "+ queue1);
        Nodes curr = queue1.peek();
        Nodes prev = queue1.poll();
        while (queue1.size() > 1) {

            curr = queue1.poll();
            if (prev == null) {
                prev = curr;
                continue;
            }
            prev.nextRight = curr;
            prev = curr;
        }
        return root;
    }


    public Nodes connectMethod2(Nodes root) {
        // Your code goes here.
        Queue<Nodes> queue = new LinkedList<Nodes>();
        queue.add(root);
        queue.add(null);
        Nodes prev = null;
        while(queue.size() > 1){
            Nodes curr = queue.poll();
            if(curr == null){
                prev.nextRight = null;
                prev= null;
                queue.add(null);
                continue;
            }
            if(prev== null){
                prev = curr;
            }else{
                prev.nextRight = curr;
            }

            if( curr.left != null){
                queue.add(curr.left);
            }

            if( curr.right != null){
                queue.add(curr.right);
            }
            prev = curr;
        }
        return root;
    }


}

class Nodes {
    int data;
    Nodes left;
    Nodes right;
    Nodes nextRight;

    Nodes(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.nextRight = null;
    }
}
