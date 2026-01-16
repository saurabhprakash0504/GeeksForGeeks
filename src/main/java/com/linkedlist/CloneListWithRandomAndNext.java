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
        if (head == null) return null;

        Node5 curr = head;

        // Step 1: Insert clone nodes after each original node
        while (curr != null) {
            Node5 copy = new Node5(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Set random pointers for clone nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original and clone lists
        curr = head;
        Node5 cloneHead = head.next;

        while (curr != null) {
            Node5 copy = curr.next;
            curr.next = copy.next;
            copy.next = (copy.next != null) ? copy.next.next : null;
            curr = curr.next;
        }

        return cloneHead;
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
