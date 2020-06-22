package com.linkedlist;

public class PairwiseSwapNodes {
	static Node head = null;

	public static void main(String[] args) {
		PairwiseSwapNodes list = new PairwiseSwapNodes();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = new Node(50);
		printLinkedList(swap2(head));

	}

	static Node swap(Node head) {
		Node curr = head;
		while (curr != null && curr.next != null) {
			// Node next = curr.next.next;
			int temp = curr.data;
			curr.data = curr.next.data;
			curr.next.data = temp;
			curr = curr.next.next;
		}
		return head;
	}

	static Node swap2(Node head) {
		if (head == null || head.next == null)
			return head;
		Node curr = head.next.next;
		Node prev = head;
		head = head.next;
		head.next = prev;

		while (curr != null && curr.next != null) {
			prev.next = curr.next;
			prev = curr;
			Node next = curr.next.next;
			curr.next.next = curr;
			curr = next;
		}
		prev.next = curr;
		return head;
	}

	private static void printLinkedList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
}
