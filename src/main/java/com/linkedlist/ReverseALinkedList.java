package com.linkedlist;

public class ReverseALinkedList {
	public static Node head;

	public static void main(String[] args) {
		ReverseALinkedList list = new ReverseALinkedList();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);

		System.out.println("Given Linked list");
		list.printing(head);
		//head = list.reverse1(head);
		//System.out.println("");
		//list.printing(haed);

		//Node recursive = reverseRecurrsion(head,null);

		Node recursive = reverseRecurrsion2(head);
		System.out.println("Reversed linked list ");
		list.printing(recursive);
	}

	Node reverse1(Node head) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	static Node reverseRecurrsion(Node head, Node prev) {
		if (head == null) {
			return prev;
		}
		Node next = head.next;
		head.next = prev;
		return reverseRecurrsion(next, head);
	}

	static Node reverseRecurrsion2(Node head) {
		if(head== null || head.next == null) {
			return head;
		}
		Node rest_head= reverseRecurrsion2(head.next);
		Node rest_tail=head.next;
		rest_tail.next=head;
		head.next=null;
		return rest_head;
	}

	public void printing(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
}
