package com.tree;

import java.util.ArrayList;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(50);
        tree.right = new Node(60);
        tree.left.left = new Node(70);
        tree.left.left.left = new Node(40);
        tree.left.right = new Node(20);
        tree.left.right.left = new Node(90);
        tree.left.right.left.left = new Node(30);
        tree.left.right.right = new Node(80);
        System.out.print("output ");
        System.out.println(findLowestCommonAncestor(tree, 60, 40).data);

        System.out.print("output2 ");
        System.out.println(findLowestCommonAncestor2(tree, 60, 40).data);

        System.out.println("output3");
        System.out.println(findPathEfficient3(tree, 60, 40).data);
    }

    static Node findLowestCommonAncestor(Node root, int first, int second) {
        Node prev = null;

        if (root == null) {
            return prev;
        }

        ArrayList<Node> list1 = new ArrayList<>();
        findPath(root, first, list1);
        System.out.println();
        flag = false;
        ArrayList<Node> list2 = new ArrayList<>();
        findPath(root, second, list2);

        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return prev;
            } else {
                prev = list1.get(i);
            }
        }
        return prev;
    }

    static boolean flag = false;

    private static void findPath(Node root, int first, ArrayList<Node> list1) {

        if (flag) {
            return;
        }

        if (root == null) {
            return;
        }

        list1.add(root);
        if (root.data == first) {
            flag = true;
            return;
        }
        findPath(root.left, first, list1);
        findPath(root.right, first, list1);

        if (!flag)
            list1.remove(root);

    }

    //secondMethod

    static Node findLowestCommonAncestor2(Node root, int first, int second) {
        Node prev = null;

        if (root == null) {
            return prev;
        }

        ArrayList<Node> list1 = new ArrayList<>();
        findPath2(root, first, list1);
        System.out.println();
        ArrayList<Node> list2 = new ArrayList<>();
        findPath2(root, second, list2);

        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return prev;
            } else {
                prev = list1.get(i);
            }
        }
        return prev;
    }


    static boolean findPath2(Node root, int search, ArrayList<Node> list){
        if(root == null){
            return false;
        }
        list.add(root);
        if (root.data == search){
            return true;
        }
       if( findPath2(root.left, search, list) || findPath2(root.right, search, list)){
           return true;
       }
        list.remove(root);
        return false;
    }

    static Node findPathEfficient3(Node root, int first, int second){
        if(root == null){
            return null;
        }

        //first condition
        if(root.data == first){
            return root;
        }

        if(root.data == second){
            return root;
        }

        Node left = findPathEfficient3(root.left, first, second);
        Node right = findPathEfficient3(root.right, first, second);

        //second condition
        if(left!= null && right!= null){
            return root;
        }

        //third condition and fouth condition
        if (left != null){
            return left;
        }else {
            return right;
        }

    }

}
