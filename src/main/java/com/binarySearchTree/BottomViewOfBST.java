package com.binarySearchTree;

import java.util.TreeMap;

public class BottomViewOfBST {

    public static void main(String[] args) {
      /*  Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50 );*/

/*        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.right = new Node(50);
        root.left.right.right = new Node(60);*/

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50 );
        root.right.left = new Node(60);
        root.right.right = new Node(70 );


        printBottomView(root);
    }

    static void printBottomView(Node root) {
        if (root == null) {
            return;
        }

        TreeMap<Integer, HeightVal> map = new TreeMap<>();

        bottomView(root, 0, 0, map);
        for(HeightVal value : map.values()){
            System.out.println(value.val);
        }
    }

    static void bottomView(Node root, int horizontalDis, int height, TreeMap<Integer, HeightVal> map) {
        if (root == null) {
            return;
        }

        if(map.containsKey(horizontalDis)){
            HeightVal result =  map.get(horizontalDis);
            if(result.height < height ){
                map.put(horizontalDis, new HeightVal(height, root.data));
            }
        }else {
            map.put(horizontalDis, new HeightVal(height, root.data));
        }

        bottomView(root.right, horizontalDis + 1, height+1, map);
        bottomView(root.left, horizontalDis - 1, height+1,map);

    }


}

class HeightVal{

    int height;
    int val;

    HeightVal(int height, int val){
        this.height = height;
        this.val = val;
    }
}
