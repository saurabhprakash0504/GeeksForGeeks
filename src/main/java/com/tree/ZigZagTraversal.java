package com.tree;

import java.util.*;

public class ZigZagTraversal {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        tree.right.left.right = new Node(8);
        ArrayList list =zigZagTraversal(tree);
        System.out.println(list);
    }

    static ArrayList<Integer> zigZagTraversal(Node root) {
        // Add your code here.
        ArrayList<Integer> list= new ArrayList<Integer>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        zigzag(root, map, 0);

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){

            if(entry.getKey() %2 ==0){
                list.addAll(entry.getValue());
            }else{
                Collections.reverse(entry.getValue());
              //  entry.getValue().reversed();
                for(int i: entry.getValue()){
                    list.add(i);
                }
              //  list.addAll(entry.getValue().reversed());

            }

        }
        return list;
    }

    static void zigzag(Node root, HashMap<Integer,List<Integer>> map, int level){
        if(root == null){
            return;
        }
        if(map.containsKey(level)){
            List<Integer> l =map.get(level);
            l.add(root.data);
            map.put(level, l);
        }else{
            List<Integer> l =new ArrayList<Integer>();
            l.add(root.data);
            map.put(level, l);
        }

        zigzag(root.left, map, level+1);
        zigzag(root.right, map, level+1);
    }
}
