package com.tree;

import java.util.ArrayList;
import java.util.HashMap;

public class TopViewOfATree {

    public static void main(String[] args) {

        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.left.left = new Node(40);
        tree.left.right = new Node(50);
        tree.left.right.left = new Node(70);
        tree.left.right.right = new Node(80);
        tree.right = new Node(30);
        tree.right.right = new Node(60);

        TopViewOfATree obj = new TopViewOfATree();
        ArrayList<Integer> al = obj.topView(tree);

        System.out.println(al);
    }

    public ArrayList<Integer> topView(Node root) {
        // code here
        HashMap<Integer,Temp> map= new HashMap<>();

        find(root, map, 0, 0);

        ArrayList<Integer> al = new ArrayList<Integer>();

        for(int i=lowest ;i<=heighest;i++){
            Temp temp = map.get(i);
            al.add(temp.value);
        }

        return al;
    }

    int lowest = Integer.MAX_VALUE;
    int heighest = Integer.MIN_VALUE;
    void find(Node root,HashMap<Integer,Temp> map, int vertical, int  height){
        if(root == null){
            return ;
        }

        if(!map.containsKey(vertical) ){
            map.put(vertical, new Temp(root.data, height));
        }else if(map.containsKey(vertical)){
            Temp val = map.get(vertical);
            int h = val.height;
            if(h > height){
                map.put(vertical, new Temp(root.data, height));
            }
        }

        if(vertical < lowest){
            lowest = vertical;
        }

        if(vertical >heighest ){
            heighest =vertical;
        }

        find(root.left, map, vertical-1, height+1);
        find(root.right, map, vertical+1, height+1);
    }
}

class Temp {
    int value;
    int height;

    Temp (int v, int h){
        value = v;
        height = h;
    }
}

