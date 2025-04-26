package com.tree;

public class ChildrenSumProperty {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(8);
        tree.right = new Node(2);
        tree.right.right = new Node(2);
       // tree.right.left = new Node(2);

        System.out.println(isChildrenSumProperty(tree));

    }

    static boolean flag = true;
    static boolean isChildrenSumProperty(Node root) {
        if (root == null) {
            return true;
        }

        isChildrenSumProperty(root.left);
        isChildrenSumProperty(root.right);
        if (root.left != null && root.right != null && root.left.data + root.right.data != root.data) {
            flag = false;
       }
        return flag;
    }
}
