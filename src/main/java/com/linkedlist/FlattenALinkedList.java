package com.linkedlist;

public class FlattenALinkedList {

    public static void main(String[] args) {

        FlattenALinkedList obj = new FlattenALinkedList();
        Node4 head = new Node4(5);
        head.bottom = new Node4(7);
        head.bottom.bottom = new Node4(8);
        head.bottom.bottom.bottom = new Node4(30);

        head.next = new Node4(10);
        head.next.bottom = new Node4(20);

        head.next.next = new Node4(19);
        head.next.next.bottom = new Node4(22);
        head.next.next.bottom.bottom = new Node4(50);

        head.next.next.next = new Node4(28);
        head.next.next.next.bottom = new Node4(35);
        head.next.next.next.bottom.bottom = new Node4(40);
        head.next.next.next.bottom.bottom.bottom = new Node4(45);

        Node4 result = obj.flatten(head);

        // Print the flattened list
        Node4 temp = result;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
    }

    public Node4 flatten(Node4 root) {
        // code here
        if (root == null) {
            return root;
        }
        Node4 prevRoot = flatten(root.next);

        Node4 root1 = merge(root, prevRoot);

        return root1;

    }

    Node4 merge(Node4 prevRoot, Node4 currRoot) {

        if (prevRoot == null) {
            return currRoot;
        }

        if (currRoot == null) {
            return prevRoot;
        }

        Node4 newRootHead = new Node4(-1);
        Node4 newRootTail = newRootHead;


        while (prevRoot != null && currRoot != null) {

            if (prevRoot.data < currRoot.data) {
                Node4 bottom = prevRoot.bottom;
                prevRoot.next = null;
                newRootTail.bottom = prevRoot;
                prevRoot = bottom;
                newRootTail = newRootTail.bottom;
            } else {
                Node4 bottom = currRoot.bottom;
                currRoot.next = null;
                newRootTail.bottom = currRoot;
                currRoot = bottom;
                newRootTail = newRootTail.bottom;
            }

        }

        if (prevRoot != null) {
            newRootTail.bottom = prevRoot;
        }

        if (currRoot != null) {
            newRootTail.bottom = currRoot;
        }

        return newRootHead.bottom;
    }
}


class Node4 {
    int data;
    Node4 next;
    Node4 bottom;

    Node4(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
