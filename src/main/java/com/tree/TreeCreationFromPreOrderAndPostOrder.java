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
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        createMap(post, map);

        return createTree(pre, post, map, 0, post.length - 1);

    }

    static void createMap(int[] post, HashMap<Integer, Integer> map) {

        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }

    }


    static int preInd = 0;

    static Node createTree(int[] pre, int[] post, HashMap<Integer, Integer> map, int postStartInd, int postEndInd) {


        if (postStartInd > postEndInd) {
            return null;
        }

        Node curr = new Node(pre[preInd]);
        preInd++;

        //This symbolises leaf node
        if (postStartInd == postEndInd) return curr;

        int newPreVal = pre[preInd];

        int postInd = map.get(newPreVal);

        curr.left = createTree(pre, post, map, postStartInd, postInd);
        curr.right = createTree(pre, post, map, postInd + 1, postEndInd - 1);

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
