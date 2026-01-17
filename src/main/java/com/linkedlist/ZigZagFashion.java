package com.linkedlist;

import static com.linkedlist.Swapkthnode.printLinkedList;

public class ZigZagFashion {

    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next = new Node(7);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(6);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);

        ZigZagFashion zz = new ZigZagFashion();
        Node result = zz.zigZag(head);
        printLinkedList(result);

    }

    Node zigZag(Node head) {
        return find(head);
    }

    Node find(Node head){
        Node curr = head;
        boolean isSmaller = true;

        while(curr.next != null){
            if(isSmaller){
                if(curr.data > curr.next.data){

                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }else{
                if(curr.data < curr.next.data){

                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                }
            }
            isSmaller = !isSmaller;
            curr = curr.next;
        }

        return head;
    }
}
