package com.linkedlist;

public class Swapkthnode {
	static Node head = null;

	public static void main(String[] args) {
		Swapkthnode list = new Swapkthnode();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = new Node(50);
		Node heads = swapkthnode(head, 5, 2);
		printLinkedList(heads);
	}

	static void printLinkedList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}

	static Node swapkthnode(Node head, int num, int K) {
		if (K > num)
			return head;
		if (2 * K - 1 == num)
			return head;

		Node curr1 = null;
		Node actual1 = head;

		Node curr2 = null;
		Node actual2 = head;

		int count = K - 1;
		while (count-- > 0) {
			curr1 = actual1;
			actual1 = actual1.next;
		}

		count = num - K;
		while (count-- > 0) {
			curr2 = actual2;
			actual2 = actual2.next;
		}


		if (curr1 != null)
			curr1.next = actual2;
		if (curr2 != null)
			curr2.next = actual1;

		Node temp = actual1.next;
		actual1.next = actual2.next;
		actual2.next = temp;

		if (K == 1)
			head = actual2;
		if (K == num)
			head = actual1;
		return head;
	}
}
