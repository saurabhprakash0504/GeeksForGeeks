package com.linkedlist;

public class RemoveDuplicate {
	static Node head;

	public static void main(String[] args) {
		RemoveDuplicate list = new RemoveDuplicate();
		list.head = new Node(2);
		list.head.next = new Node(2);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = new Node(40);
		list.head.next.next.next.next.next = new Node(60);

		System.out.println("Given Linked list");
		list.printing(head);
		System.out.println("after");
		Node heads= removeDuplicates(head);
		list.printing(heads);

	}

	public void printing(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}


	static Node removeDuplicates(Node root) {
		Node prev = root;
		Node head = root.next;
		while (head != null) {
			if (prev.data == head.data) {
				prev.next = head.next;
			} else {
				prev.next = head;
				prev = head;

			}
			head = head.next;

		}
		return root;
	}
}
