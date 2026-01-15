package com.linkedlist;

public class MergeSortALinkedList {

    public static void main(String[] args) {

        MergeSortALinkedList obj = new MergeSortALinkedList();
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        Node result = obj.mergeSort(head);

        // Print the sorted list
        Node temp = result;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public Node mergeSort(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node mid = findMid(head);
        Node temp = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(temp);
        return merge(left, right);

    }


    Node findMid(Node head){

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    Node merge(Node left, Node right){
        Node newNodeHead = new Node(-1);
        Node newNodeTail = newNodeHead;

        while(left != null && right != null){
            if(left.data < right.data){
                Node temp = left.next;
                left.next = null;
                newNodeTail.next = left;
                newNodeTail = newNodeTail.next;
                left = temp;
            }else {
                Node temp = right.next;
                right.next = null;
                newNodeTail.next = right;
                newNodeTail = newNodeTail.next;
                right = temp;
            }
        }

        if(left != null){
            newNodeTail.next = left;
        }

        if(right != null){
            newNodeTail.next = right;
        }

        return newNodeHead.next;
    }
}
