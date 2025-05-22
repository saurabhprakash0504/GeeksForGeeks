package com.tree;

import com.linkedlist.CountNodesInLoop;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertListToTree {
    static com.linkedlist.Node head = null;

    public static void main(String[] args) {

        ConvertListToTree list = new ConvertListToTree();
        list.head = new com.linkedlist.Node(10);
        list.head.next = new com.linkedlist.Node(20);
        list.head.next.next = new com.linkedlist.Node(30);
        list.head.next.next.next = new com.linkedlist.Node(40);

        Node node = linkedListToBinaryTree(head);

        System.out.println(node);


    }

    public static Node linkedListToBinaryTree(com.linkedlist.Node head) {
        if (head == null) return null;

        Node root = new Node(head.data);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        head = head.next;

        while (head != null) {
            Node parent = q.poll();

            // Left child
            Node leftChild = new Node(head.data);
            parent.left = leftChild;
            q.add(leftChild);
            head = head.next;
            if (head == null) break;

            // Right child
            Node rightChild = new Node(head.data);
            parent.right = rightChild;
            q.add(rightChild);
            head = head.next;
        }

        return root;
    }
}
