package com.linkedlist;

public class RemoveLoopInLinkedList {

    public static void main(String[] args) {

        RemoveLoopInLinkedList obj = new RemoveLoopInLinkedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        // Creating a loop for testing
        head.next.next.next.next.next = head.next; // 5 -> 2 creates a loop

        obj.removeLoop(head);

        // Print the list after removing loop
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public static void removeLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            return;
        }

        // Step 2: Find start of loop
        slow = head;

        // Case A: Loop starts at head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;   // break loop
            return;
        }

        Node prev = null;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;

    }

}
