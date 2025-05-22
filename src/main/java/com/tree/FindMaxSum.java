package com.tree;

public class FindMaxSum {

    public static void main(String[] args) {

        Node tree = new Node(10);
        tree.left = new Node(2);
        tree.right = new Node(10);
        tree.left.left = new Node(20);
        tree.left.right = new Node(1);
        tree.right.right = new Node(-25);
        tree.right.right.left = new Node(3);
        tree.right.right.right = new Node(4);

        int max = findMaxSum(tree);

        System.out.println("value " + max);
    }

    static int findMaxSum(Node node) {
        // your code goes here
        Test test = new Test();

        findMax(node,  test);

        return test.max;

    }

    static int findMax(Node node, Test test) {

        if (node == null) {
            return 0;
        }

        int left = findMax(node.left,  test);

        int right = findMax(node.right,  test);

        int val = Integer.max(Integer.max(Integer.max(left + node.data, right + node.data), node.data), left + right + node.data);

        test.max = Integer.max(val, test.max);

        int singlePathSum  = Integer.max(Integer.max(Integer.max(left+ node.data, right + node.data), node.data), left + right + node.data);
        return singlePathSum;

    }
}


class Test {
    int max;
}
