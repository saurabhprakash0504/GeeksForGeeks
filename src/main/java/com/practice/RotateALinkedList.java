package com.practice;

import com.linkedlist.Node;

public class RotateALinkedList {
    static Node head;
    public static void main(String[] args) {
        RotateALinkedList list = new RotateALinkedList();
        head = new Node(10);
        head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = new Node(40);
     //   list.head.next.next.next.next = new Node(50);
        Node temp = rotate(head, 6);
        System.out.println(temp.data);
    }

   static public Node rotate(Node head, int k) {
       // add code here
       int size=0;
       Node curr = head;
       while(curr != null){
           if(size == k-1){
               break;
           }else{
               curr = curr.next;
               size++;
           }
       }
       if(size == k-1){
           Node temp = curr.next;
           curr.next = null;
           temp.next = head;
           return temp;
       }else{
           int d = k%size;
           int i =1;
           Node curr1= head;
           // System.out.println("curr1 >>"+ curr1 );
           while(i < d){
               curr1 = curr1.next;
               i++;
           }
           Node temp = curr1.next;
           curr1.next = null;
           while (curr1!=null){
               
           }
           temp.next = head;
           return temp;
       }
       // return temp;
   }
}
