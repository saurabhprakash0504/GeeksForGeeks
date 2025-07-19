package com.tree;

import java.util.HashMap;


public class TreeCreationFromPreOrderAndPostOrder {

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] postOrder = {4, 5, 2, 6, 7, 3, 1};

        //  Node node = buildTree(inOrder, postorder);

        Node root = buildTree(preOrder, postOrder);


        System.out.println(root);
    }


    static int preIndex;

    public static Node buildTree(int preOrder[], int postorder[]) {
        preIndex = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return build(preOrder, postorder, map, 0, preOrder.length - 1);
    }

    static Node build(int preOrder[], int postorder[], HashMap<Integer, Integer> map, int preOrderStart, int preOrderEnd) {
        if (preOrderStart > preOrderEnd) {
            return null;
        }



        Node curr = new Node(preOrder[preIndex]);
        int index = map.get(curr.data);
        preIndex++;

        int leftLength = index - preOrderStart;
        int rightLength = preOrderEnd - (index+1);

        curr.left = build(preOrder, postorder, map, preOrderStart, index - 1);
        // Important: build right subtree first because we're going from end to start
        curr.right = build(preOrder, postorder, map, index + 1, preOrderEnd-1);


        return curr;
    }
}
