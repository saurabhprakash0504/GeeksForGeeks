package com.tree;

public class PopulateInorderSuccessorforAllNodes {

    public static void main(String[] args) {
        Node5 root = new Node5(10);
        root.left = new Node5(8);
        root.right = new Node5(12);
        root.left.left = new Node5(3);
        root.left.right = new Node5(9);

        new PopulateInorderSuccessorforAllNodes().populateNext(root);

        // Test the populated inorder successors
        System.out.println("Inorder Successor of 3 is " + (root.left.left.next != null ? root.left.left.next.data : "null"));
        System.out.println("Inorder Successor of 8 is " + (root.left.next != null ? root.left.next.data : "null"));
        System.out.println("Inorder Successor of 9 is " + (root.left.right.next != null ? root.left.right.next.data : "null"));
        System.out.println("Inorder Successor of 10 is " + (root.next != null ? root.next.data : "null"));
        System.out.println("Inorder Successor of 12 is " + (root.right.next != null ? root.right.next.data : "null"));
    }

     /* public void populateNext(Node root) {
        // code here

        inOrder(root);
        Node prev = null;
        while(!stack.isEmpty()){

            Node curr = stack.pop();
            curr.next = prev;

            prev = curr;

        }


    }

    Stack<Node> stack = new Stack<>();
    void inOrder(Node root){
        if(root == null){
            return ;
        }
        inOrder(root.left);
        stack.push(root);
        inOrder(root.right);
    }*/

    Node5 prev = null;
    public void populateNext(Node5 root) {

        if(root == null){
            return;
        }

        populateNext(root.right);
        root.next = prev;
        prev = root;
        populateNext(root.left);


    }
}

class Node5 {
    int data;
    Node5 left, right, next;

    Node5(int item) {
        data = item;
        left = right = next = null;
    }
}
