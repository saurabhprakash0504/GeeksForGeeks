package com.tree;

public class HouseRobbery3 {

    public static void main(String[] args) {


    }

    public int rob(Node root) {

        int[] res = find(root);
        return Integer.max(res[0], res[1]);

    }

    //inc is 0;
    //exc is 1;
    int[] find(Node root){

        if(root == null){
            return new int[]{0,0};
        }

        int[] left = find(root.left);
        int[] right = find(root.right);

        int inc = root.data + left[1]+ right[1];

        int exc = Integer.max(left[0], left[1]) + Integer.max(right[0], right[1]);

        return new int[] {inc, exc};

    }
}
