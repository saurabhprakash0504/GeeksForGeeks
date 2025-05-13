package com.binarySearchTree;

public class CreateInOrderToPostOrder {

    public static void main(String[] args) {
        int[] inorder = {9, 5, 2, 3, 4};
        int[] postOrder = {5, 9, 3, 4, 2};

        Node node = buildTree(inorder, postOrder);
        System.out.println("node " + node);
    }

    static Node buildTree(int[] inorder, int[] postorder) {
        // code here
        postOrder = postorder.length - 1;
        return construct(postorder, inorder, 0, inorder.length - 1);
    }

    static int postOrder;

    static Node construct(int[] post, int[] in, int start, int end) {
        if (start > end) {
            return null;
        }

        Node node = new Node(post[postOrder--]);
        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == node.data) {
                index = i;
                break;
            }
        }

        node.right = construct(post, in, index + 1, end);
        node.left = construct(post, in, start, index - 1);


        return node;

    }
}
