package com.linkedlist;

import java.util.HashMap;

public class CloneListWithRandomAndNext {

    public static void main(String[] args) {
        //create a linked list with random and next pointers
        Node5 head = new Node5(1);
        head.next = new Node5(2);
        head.next.next = new Node5(3);
        head.next.next.next = new Node5(4);
        head.next.next.next.next = new Node5(5);

        //create random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next;
        head.next.next.next.next.random = head.next.next;

        CloneListWithRandomAndNext obj = new CloneListWithRandomAndNext();
        Node5 cloneHead = obj.cloneLinkedList(head);

        //print the cloned linked list
        Node5 curr = cloneHead;
        while (curr != null) {
            int randomData = (curr.random != null) ? curr.random.data : -1;
            System.out.println("Node data: " + curr.data + ", Random data: " + randomData);
            curr = curr.next;
        }

    }

    //METHOD 1 - USING HASHMAP
  /*  public Node5 cloneLinkedList(Node5 head) {

        //clone a new map
        //create a map
        //mark the new random links in clone map

        Node5 clonehead = new Node5(-1);
        Node5 cloneTail = clonehead;
        Node5 curr = head;
        while(curr != null){
            Node5 next = curr.next;
            int data = curr.data;
            Node5 newNode5 = new Node5(data);
            cloneTail.next = newNode5;
            cloneTail = cloneTail.next;
            curr = curr.next;
        }

        //STEP 2
        curr = head;
        Node5 clone = clonehead.next;
        HashMap<Node5,Node5> map = new HashMap<Node5,Node5>();
        while(curr != null ){
            map.put(curr, clone);
            curr = curr.next;
            clone = clone.next;
        }

        //STEP 3
        curr = head;
        clone = clonehead.next;
        while(curr != null){
            Node5 random = curr.random;
            Node5 temp = map.get(random);
            clone.random = temp;
            curr = curr.next;
            clone = clone.next;
        }

        return clonehead.next;


    }*/

    //METHOD 2 - OPTIMIZED APPROACH
    public Node5 cloneLinkedList(Node5 head) {

        Node5 curr = head;
        Node5 cloneHead = new Node5(-1);
        Node5 cloneTail = cloneHead;

        //Step 1
        while(curr != null){
            Node5 next = curr.next;
            int data = curr.data;
            Node5 temp = new Node5(data);
            cloneTail.next = temp;
            cloneTail = cloneTail.next;
            curr = next;
        }

        //Step 2
        curr = head;
        Node5 cloneCurr = cloneHead.next;
        while(curr != null){
            Node5 next = curr.next;
            curr.next = cloneCurr;

            Node5 cloneNext = cloneCurr.next;
            cloneCurr.next = next;

            curr = next;
            cloneCurr = cloneNext;
        }

        //Step 3
        curr = head;
        cloneCurr = cloneHead.next;
        while(curr != null && cloneCurr != null ){
            Node5 currRandom = curr.random;
            cloneCurr.random =  (currRandom != null) ? currRandom.next : null;

            curr = curr.next.next;
            if(cloneCurr.next != null)
                cloneCurr = cloneCurr.next.next;
            else
                break;
        }


        //Step 4
        curr = head;
        cloneCurr = cloneHead.next;
        while(curr != null && cloneCurr != null){

            curr.next = cloneCurr.next;
            curr = curr.next;

            if(curr != null){
                cloneCurr.next = curr.next;
            }
            cloneCurr = cloneCurr.next;
        }
        return cloneHead.next;
    }
}

class Node5 {
    int data;
    Node5 next;
    Node5 random;

    Node5(int x) {
        data = x;
        next = null;
        random = null;
    }
}
