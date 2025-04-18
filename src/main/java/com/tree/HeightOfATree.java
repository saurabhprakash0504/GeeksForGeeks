package com.tree;

public class HeightOfATree {

    public static void main(String[] args) {
/*        Node tree = new Node(10);
        tree.left = new Node(20);
        tree.left.left = new Node(40);
        tree.left.right = new Node(50);
        tree.left.right.left = new Node(70);
        tree.left.right.right = new Node(80);
        tree.right = new Node(30);
        tree.right.right = new Node(60);*/

        Node tree = new Node(12);
        tree.left = new Node(8);
        tree.left.left = new Node(5);
        tree.left.right = new Node(11);
        tree.right = new Node(18);

        System.out.println("height of a tree "+ heightOfATree(tree));
    }

    static int heightOfATree(Node node){

        if( node == null){
            return 0;
        }

        int left =  heightOfATree(node.left);
        int right =  heightOfATree(node.right);

        int max = Integer.max(left, right) +1;
      //  System.out.println(max);
        return max;
    }


}
