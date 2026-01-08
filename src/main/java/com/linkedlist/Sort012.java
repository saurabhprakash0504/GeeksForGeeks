package com.linkedlist;

public class Sort012 {

    public static void main(String[] args) {

        Sort012 obj = new Sort012();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);

        Node sortedHead = obj.segregate(head);

        System.out.println(sortedHead);
    }

    public Node segregate(Node head) {
        // code here
        Node node0 = null;
        Node node1 = null;
        Node node2 = null;

        Node curr = head;

        Node head0 = null;
        Node head1 = null;
        Node head2 = null;


        while (curr != null) {
            // Node next = curr.next;
            int data = curr.data;

            if (data == 0) {
                if (node0 == null) {
                    node0 = curr;
                    head0 = node0;
                    //  node0 = node0.next;
                } else {
                    node0.next = curr;
                    node0 = node0.next;
                }


            } else if (data == 1) {
                if (node1 == null) {
                    node1 = curr;
                    head1 = node1;
                    // node1 = node1.next;
                } else {
                    node1.next = curr;
                    node1 = node1.next;
                }


            } else {

                if (node2 == null) {
                    node2 = curr;
                    head2 = node2;
                    // node2 = node2.next;
                } else {
                    node2.next = curr;
                    node2 = node2.next;

                }

            }

            curr = curr.next;
        }

        // Important: break old links to avoid cycles
        if (node0 != null) node0.next = null;
        if (node1 != null) node1.next = null;
        if (node2 != null) node2.next = null;


        Node newHead;

        if (head0 != null) {
            // Start with 0s
            newHead = head0;

            if (head1 != null) {
                node0.next = head1;   // 0 → 1
                if (head2 != null) {
                    node1.next = head2;   // 1 → 2
                }
            } else {
                node0.next = head2;   // 0 → 2 (no 1s)
            }

        } else if (head1 != null) {
            // No 0s, start with 1s
            newHead = head1;

            if (head2 != null) {
                node1.next = head2;   // 1 → 2
            }

        } else {
            // Only 2s exist
            newHead = head2;
        }

        return newHead;

    }
}
