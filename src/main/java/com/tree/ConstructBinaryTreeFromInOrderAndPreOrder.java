package com.tree;

public class ConstructBinaryTreeFromInOrderAndPreOrder {

    public static void main(String[] args) {
        int[] inOrder = {20, 10, 40, 30, 50};
        int[] preOrder = {10, 20, 30, 40, 50};

        Node root = createTree(inOrder, preOrder, 0, inOrder.length - 1);

        System.out.println(root.data);

    }

    static int preOrderIndex = 0;


    static Node createTree(int[] inOrder, int[] preOrder, int inS, int inE) {


        if (inS > inE) {
            return null;
        }

        Node curr = new Node(preOrder[preOrderIndex++]);

        int index = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (curr.data == inOrder[i]) {
                index = i;
                break;
            }
        }

        curr.left = createTree(inOrder, preOrder, inS, index - 1);
        curr.right = createTree(inOrder, preOrder, index + 1, inE);

        return curr;
    }
}
