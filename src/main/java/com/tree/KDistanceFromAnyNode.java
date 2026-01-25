package com.tree;

import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class KDistanceFromAnyNode {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int target = 2;
        int k = 1;
        ArrayList<Integer> result = KDistanceNodes(root, target, k);
        System.out.println("Nodes at distance " + k + " from target " + target + ": " + result);

    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        // return the sorted list of all nodes at k dist
        HashMap<Node,Node> childParentMap = new HashMap<>();
        Node curr = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            Node left = poll.left;
            if(left != null){
                queue.add(left);
                childParentMap.put(left, poll);
            }
            Node right = poll.right;
            if(right != null){
                queue.add(right);
                childParentMap.put(right, poll);
            }
        }


        curr = root;
        queue = new LinkedList<>();
        queue.add(curr);
        Node newNode = null;
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.data == target){
                newNode = poll;
                break;
            }else{
                Node left = poll.left;
                if(left != null){
                    queue.add(left);
                }
                Node right = poll.right;
                if(right != null){
                    queue.add(right);
                }
            }
        }


        Queue<Node> newQueue = new LinkedList<Node>();
        HashSet<Node> visited = new HashSet<Node>();
        int dis = 0;

        newQueue.add(newNode);
        ArrayList<Integer> al = new ArrayList<Integer>();
        while(!newQueue.isEmpty()){
            if(k == dis){

                while(!newQueue.isEmpty()){
                    Node p = newQueue.poll();
                    al.add(p.data);
                }
                Collections.sort(al);
                return al;
            }
            Queue<Node> tempQ = new LinkedList<Node>();
            while(!newQueue.isEmpty()){

                Node t = newQueue.poll();

                tempQ.add(t);
            }

            dis = dis +1;
            while(!tempQ.isEmpty()){
                Node p = tempQ.poll();
                visited.add(p);
                if(p != null && p.left != null && !visited.contains(p.left)){
                    visited.add(p.left);
                    newQueue.add(p.left);
                }
                if(p != null && p.right != null && !visited.contains(p.right)){
                    visited.add(p.right);
                    newQueue.add(p.right);
                }
                Node par = childParentMap.get(p);
                if(par != null && !visited.contains(par)){
                    visited.add(par);
                    newQueue.add(par);
                }
            }

        }

        return al;
    }
}
