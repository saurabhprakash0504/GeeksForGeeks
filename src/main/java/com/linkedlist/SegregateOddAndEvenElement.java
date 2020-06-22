package com.linkedlist;

public class SegregateOddAndEvenElement {
	static Node head = null;

	public static void main(String[] args) {
		SegregateOddAndEvenElement list = new SegregateOddAndEvenElement();
		list.head = new Node(10);
		list.head.next = new Node(21);
		list.head.next.next = new Node(32);
		list.head.next.next.next = new Node(44);
		list.head.next.next.next.next = new Node(445);
		list.head.next.next.next.next.next = new Node(448);
		printLinkedList(seperate(head));
	}

	static Node seperate(Node head) {
		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;
		Node curr = head;
		while (curr != null) {
			if ((curr.data) % 2 == 0) {
				if (evenStart == null) {
					evenStart = curr;
					evenEnd = evenStart;
				} else {
					evenEnd.next = curr;
					evenEnd = evenEnd.next;
				}
			} else {
				if (oddStart == null) {
					oddStart = curr;
					oddEnd = oddStart;
				} else {
					oddEnd.next = curr;
					oddEnd = oddEnd.next;
				}
			}
			curr = curr.next;
		}
		if (oddEnd == null) {
			return evenStart;
		}
		if (evenEnd == null) {
			return oddStart;
		}
		evenEnd.next = oddStart;
		oddEnd.next = null;
		return evenStart;
	}

	private static void printLinkedList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
}
