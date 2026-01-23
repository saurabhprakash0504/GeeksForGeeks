package com.tree;

import java.util.ArrayList;
import java.util.HashMap;

public class BottomViewOfATree {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.left.left = new Node(40);
        tree.left.right = new Node(50);
        tree.left.right.left = new Node(70);
        tree.left.right.right = new Node(80);
        tree.right = new Node(30);
        tree.right.right = new Node(60);

        BottomViewOfATree bvt = new BottomViewOfATree();
        ArrayList<Integer> result = bvt.bottomView(tree);
        System.out.println(result);
    }

    //Recurssive Approach
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        HashMap<Integer, Temp1> map = new HashMap<>();
        find(root, map, 0, 0);

        for (int i = low; i <= high; i++) {
            al.add(map.get(i).val);
        }

        return al;


    }

    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;

    void find(Node root, HashMap<Integer, Temp1> map, int vertical, int height) {
        if (root == null) {
            return;
        }

        low = Integer.min(low, vertical);
        high = Integer.max(high, vertical);

        if (!map.containsKey(vertical)) {
            map.put(vertical, new Temp1(root.data, vertical, height));
        } else {
            Temp1 t = map.get(vertical);
            if (t.height <= height) {
                map.put(vertical, new Temp1(root.data, vertical, height));
            }
        }

        find(root.left, map, vertical - 1, height + 1);
        find(root.right, map, vertical + 1, height + 1);

    }

}

class Temp1 {
    int val;
    int vertical;
    int height;

    Temp1(int v, int ver, int h) {
        val = v;
        vertical = ver;
        height = h;
    }
}

