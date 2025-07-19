package com.tree;

import java.util.HashMap;


public class TreeCreationFromInOrderAndPostOrder {

    public static void main(String[] args) {
        int[] inOrder = {40, 20, 50, 10, 60, 30};
        int[] postorder = {40, 50, 20, 60, 30, 10};

      //  Node node = buildTree(inOrder, postorder);

        Node root = buildTree2(inOrder, postorder);



        System.out.println(root);
    }

 /*   //Method 1 - I am not in favour.
    //USE METHOD 2
    public static Node buildTree(int inorder[], int postorder[]) {
        // code here
       // preIndex = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, map, 0, inorder.length - 1, 0, postorder.length - 1);

    }

    static Node build(int inorder[], int postorder[], HashMap<Integer, Integer> map, int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }

        Node curr = new Node(postorder[pe]);
        int index = map.get(curr.data);

        int moveleft = index - is;


        curr.left = build(inorder, postorder, map, is, index - 1, ps, ps + moveleft - 1);
        curr.right = build(inorder, postorder, map, index + 1, ie, ps + moveleft, pe - 1);

        return curr;

    }*/


    //METHOD 2

    static int postIndex;

    public static Node buildTree2(int inorder[], int postorder[]) {
        postIndex = postorder.length - 1; // start from the last element in postorder

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build2(inorder, postorder, map, 0, inorder.length - 1);
    }

    static Node build2(int inorder[], int postorder[], HashMap<Integer, Integer> map, int is, int ie) {
        if (is > ie) {
            return null;
        }

        Node curr = new Node(postorder[postIndex--]);
        int index = map.get(curr.data);

        // Important: build right subtree first because we're going from end to start
        curr.right = build2(inorder, postorder, map, index + 1, ie);
        curr.left = build2(inorder, postorder, map, is, index - 1);

        return curr;
    }
}
