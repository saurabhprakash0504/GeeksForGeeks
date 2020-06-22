package com.linkedlist;

public class ReverseDoublyLinkedList {

	static DoublyNode head, tail = null;

	public static void main(String[] args) {
		ReverseDoublyLinkedList list = new ReverseDoublyLinkedList();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.addNode(50);

		display(head);

		DoublyNode head2 = reverseDLL(head);
		System.out.println();
		display(head2);
	}


	public static DoublyNode reverseDLL(DoublyNode  head)
	{
		DoublyNode curr= head;
		DoublyNode prev= null;
	    while(curr!= null){
	    	DoublyNode next = curr.next;
	        curr.prev=next;
	        curr.next= prev;

	        prev = curr;
	        curr=next;
	    }
	    return prev;
	}


	static public void display(DoublyNode heads) {
		// Node current will point to head
		DoublyNode current = heads;
		if (heads == null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of doubly linked list: ");
		while (current != null) {
			// Prints each node by incrementing the pointer.

			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	public void addNode(int data) {
		// Create a new node
		DoublyNode newNode = new DoublyNode(data);

		// If list is empty
		if (head == null) {
			// Both head and tail will point to newNode
			head = tail = newNode;
			// head's previous will point to null
			head.prev = null;
			// tail's next will point to null, as it is the last node of the list
			tail.next = null;
		} else {
			// newNode will be added after tail such that tail's next will point to newNode
			tail.next = newNode;
			// newNode's previous will point to tail
			newNode.prev = tail;
			// newNode will become new tail
			tail = newNode;
			// As it is last node, tail's next will point to null
			tail.next = null;
		}
	}

}
