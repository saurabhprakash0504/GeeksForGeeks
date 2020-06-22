package com.linkedlist;

public class DeleteANodeWithAddressToITWithoutHEAD {

	static Node head = null;

	public static void main(String[] args) {
		DeleteANodeWithAddressToITWithoutHEAD list = new DeleteANodeWithAddressToITWithoutHEAD();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		delete(head.next.next);
		printLinkedList(head);
	}

	static void delete(Node node) {

		node.data=node.next.data;
		node.next=node.next.next;

	}

	private static void printLinkedList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
}
