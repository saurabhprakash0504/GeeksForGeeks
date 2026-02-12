package com.dynamicProgramming;

import com.tree.Node;

public class HouseRobbery3 {

    // YT- Nikhil Lohia
    public static void main(String[] args) {

    }

    int[] find(Node root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = find(root.left);
        int[] right = find(root.right);

        int inc = root.data + left[1] + right[1];

        int exc = Integer.max(left[0], left[1]) + Integer.max(right[0], right[1]);

        return new int[]{inc, exc};

    }
}
