package com.tree;

import java.util.HashMap;


public class TreeCreationFromPreOrderAndPostOrder {

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        int[] postOrder = {4, 5, 2, 6, 7, 3, 1};

        Node root = constructTree1(preOrder, postOrder);

        System.out.println(root);
    }


    //YT - NEETCODE
    public static Node constructTree1(int[] pre, int[] post) {
        return buildTree(pre, post);
    }


    static int preIndex;

    public static Node buildTree(int preOrder[], int postOrder[]) {
        preIndex = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postOrder.length; i++) {
            map.put(postOrder[i], i);
        }

        return build(preOrder, postOrder, map, 0, postOrder.length - 1);
    }

    static Node build(int preOrder[], int postorder[], HashMap<Integer, Integer> map, int postOrderStart, int postOrderEnd) {
        if (preIndex >= preOrder.length || postOrderStart > postOrderEnd) {
            return null;
        }

        Node curr = new Node(preOrder[preIndex++]);

        if (postOrderStart == postOrderEnd) return curr;

        int leftRootVal = preOrder[preIndex];
        int index = map.get(leftRootVal);

        curr.left = build(preOrder, postorder, map, postOrderStart, index);

        curr.right = build(preOrder, postorder, map, index + 1, postOrderEnd - 1);


        return curr;
    }

    //YT- Jenny lecture

    public Node constructTree2(int[] pre, int[] post) {
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
