package com.tree;

import com.hash.CheckEqualArray;

public class DiameterOfATree {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.right = new Node(60);
        tree.left.left = new Node(30);
        tree.left.left.left = new Node(40);
        tree.left.left.right = new Node(50);
        tree.left.left.left.left = new Node(100);
        tree.left.right = new Node(80);
        tree.left.right.right = new Node(90);
        tree.left.right.right.right = new Node(18);
        System.out.println(findDiameter(tree));


        height2(tree);

        System.out.println(maxHeights);


    }

    //FirstMethod

    static int findDiameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int diameter = 1 + leftHeight + rightHeight;

        int leftDiameter = findDiameter(root.left);
        int rightDiameter = findDiameter(root.right);

        return Integer.max(Integer.max(diameter, leftDiameter), rightDiameter);
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int height = 1 + Integer.max(leftHeight, rightHeight);

        return height;

    }




    //SecondMethod


    static int maxHeights = Integer.MIN_VALUE;

    static int height2(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);

        int diammeter = 1 + leftHeight + rightHeight;

        maxHeights = Integer.max(diammeter, maxHeights);
        return 1 + Integer.max(leftHeight, rightHeight);

    }

}
