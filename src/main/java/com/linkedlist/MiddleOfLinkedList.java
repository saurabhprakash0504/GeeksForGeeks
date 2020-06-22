package com.linkedlist;

public class MiddleOfLinkedList {
	static Node head;

	public static void main(String[] args) {
		MiddleOfLinkedList list = new MiddleOfLinkedList();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = new Node(50);
		list.head.next.next.next.next.next = new Node(60);

		System.out.println("Given Linked list");
		list.printing(head);

		System.out.println(" mid value >> " + findMid(head));
		System.out.println(" get middle  >> " + getMiddle(head));
	}

	static Integer findMid(Node head) {
		if (head == null) {
			return null;
		}
		Node curr = head;
		Node nextCurr = head;

		while (nextCurr != null && nextCurr.next != null) {
			curr = curr.next;
			nextCurr = nextCurr.next.next;
		}
		return curr.data;

	}

	static int getMiddle(Node head) {
		Node fast = head;
		Node slow = head;
		while (fast!=null && fast.next!= null ) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.data;
	}

	public void printing(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
}
