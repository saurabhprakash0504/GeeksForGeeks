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


    //YT - NEETCODE
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
        int rightLength = preOrderEnd - (index + 1);

        curr.left = build(preOrder, postorder, map, preOrderStart, index - 1);
        // Important: build right subtree first because we're going from end to start
        curr.right = build(preOrder, postorder, map, index + 1, preOrderEnd - 1);


        return curr;
    }

    //YT- Jenny lecture

    public Node constructTree(int[] pre, int[] post) {
        // code here

        HashMap<Integer, Node> map = new HashMap<>();
        Node root = new Node(pre[0]);
        map.put(pre[0], root);
        find(pre, post, map);

        return root;
    }


    void find(int[] pre, int[] post, HashMap<Integer, Node> map) {

        int index = 1;

        while (index < pre.length) {

            int val = pre[index];
            index++;

            int postIndex = -1;
            for (int i = 0; i < post.length; i++) {
                if (post[i] == val) {
                    postIndex = i;
                    break;

                }
            }

            for (int i = postIndex + 1; i < post.length; i++) {

                if (map.containsKey(post[i])) {
                    //    System.out.println("val >> "+ val);

                    Node node = map.get(post[i]);

                    //  System.out.println("prevNodeVal >>"+ node.data);

                    Node newNode = new Node(val);

                    if (node.left == null) {
                        node.left = newNode;
                        map.put(val, newNode);
                        break;
                    } else {
                        node.right = newNode;
                        map.put(val, newNode);
                        break;
                    }

                }

            }
        }
    }
}
