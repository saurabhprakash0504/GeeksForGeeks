package com.linkedlist;

public class LinkedListGroupReverse {

    public static void main(String[] args) {

        LinkedListGroupReverse obj = new LinkedListGroupReverse();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;

        Node result = obj.reverseKGroup(head, k);

        // Print the modified list
        Node temp = result;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public Node reverseKGroup(Node head, int k) {
        // code here
        Node curr = head;

        Node firstHead = null;

        Node lastNode = null;
        while (curr != null) {

            Node tempHead = curr;
            Node temp = curr;
            int i = 1;
            while (temp != null && i != k) {
                temp = temp.next;
                i++;
            }
            if (temp == null || i < k) {
                Node rev = reverse(tempHead);
                lastNode.next = rev;
                break;
            }

            Node nextNode = null;
            if (temp != null)
                nextNode = temp.next;

            temp.next = null;
            Node rev = reverse(tempHead);
            if (firstHead == null) {
                firstHead = rev;
            } else {
                lastNode.next = rev;
            }
            lastNode = curr;
            curr = nextNode;
        }

        return firstHead;
    }

    Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
