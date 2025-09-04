package com.linkedlist;

public class SwapKthNodePractice {
    static Node head = null;

    public static void main(String[] args) {
        SwapKthNodePractice list = new SwapKthNodePractice();
        list.head = new Node(5);
        list.head.next = new Node(10);
        list.head.next.next = new Node(8);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(9);
        list.head.next.next.next.next.next = new Node(3);
        Node heads = swapKth(head, 2);
        printLinkedList(heads);
    }

    public static Node swapKth(Node head, int k) {
        // code here
        int len = 0;
        Node curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        if (k > len) {
            return head;
        }


        int a = 1;
        Node prev1 = null;
        Node curr1 = head;
        while (a < k) {
            prev1 = curr1;
            curr1 = curr1.next;
            a = a + 1;
        }


        int b = 1;
        Node prev2 = null;
        Node curr2 = head;
        while (b < ((len - k) + 1)) {
            prev2 = curr2;
            curr2 = curr2.next;
            b = b + 1;
        }


        if (prev1 != null) {
            prev1.next = curr2;
        } else {
            head = curr2;
        }

        if (prev2 != null) {
            prev2.next = curr1;
        } else {
            head = curr1;
        }


        Node temp = curr1.next;

        curr1.next = curr2.next;
        curr2.next = temp;

        return head;
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }


    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
