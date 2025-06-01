package com.binarySearchTree;
import java.util.*;


public class VerticalView {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right.left = new Node(90);
        root.right.right = new Node(100);

        ArrayList<Integer> al = topView(root);
        System.out.print(al);


    }

    static ArrayList<Integer> topView(Node root) {
        // code here
        TreeMap<Integer,Trees> map = new TreeMap<Integer,Trees>();

        find(root, 0, map, 0);

        ArrayList<Integer> al = new ArrayList<Integer>();
        for(Map.Entry<Integer,Trees> entry: map.entrySet()){
            Trees t = entry.getValue();
            al.add(t.value);
        }

        return al;

    }

    static void find(Node root, int vertical,  TreeMap<Integer,Trees> map, int level ){

        if(root == null){
            return;
        }
        if(map.containsKey(vertical)){

            Trees t = map.get(vertical);
            if(t.level > level){
                Trees tt = new Trees(level, root.data);
                map.put(vertical, tt);
            }
            //  map.put(vertical, root.data);
        }else{
            Trees tt = new Trees(level, root.data);
            map.put(vertical, tt);
        }

        find(root.left, vertical-1, map, level+1);
        find(root.right, vertical+1, map, level+1);
    }
}


class Trees{
    int level;
    int value;
    Trees(int l, int v){
        level = l;
        value = v;
    }
}
