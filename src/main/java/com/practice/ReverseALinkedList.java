package com.practice;

import com.linkedlist.Node;

public class ReverseALinkedList {

    static Node head;

    public static void main(String[] args) {
        ReverseALinkedList list = new ReverseALinkedList();
        head = new Node(10);
        head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = new Node(40);
        System.out.println(reverseList(head));
    }

    static Node reverseList(Node head) {
        // code here
        Node prev= null;
        Node curr = head;
        while(curr!= null){
            Node temp = curr.next;

            curr.next = prev;
            prev= curr;

            curr = temp;
        }
        return prev;

    }
}
