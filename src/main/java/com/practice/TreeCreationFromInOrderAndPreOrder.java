package com.practice;

import com.tree.*;
import java.util.*;



public class TreeCreationFromInOrderAndPreOrder {

    public static void main(String[] args) {
        int[] inOrder = {1,6,8,7};
        int[] preOrder = { 1,6,7,8};

        Node node = buildTree(inOrder, preOrder);
        System.out.println(node);
    }

    static int preIndex = 0;
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        preIndex = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i< inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(inorder, preorder, map, 0, inorder.length-1);

    }

    static Node build(int inorder[], int preorder[], HashMap<Integer,Integer> map, int is, int ie){
        if(is > ie){
            return null;
        }

        Node curr = new Node(preorder[preIndex++]);
        int index = map.get(curr.data);

        curr.left = build(inorder, preorder, map, is, index-1);
        curr.right = build(inorder, preorder, map, index+1, ie);

        return curr;

    }
}
