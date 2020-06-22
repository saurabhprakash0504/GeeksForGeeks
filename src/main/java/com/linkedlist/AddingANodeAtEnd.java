package com.linkedlist;

public class AddingANodeAtEnd {
	static Node head;
	static Node end;
	public static void main(String[] args) {
		insertEnd2(10);
		insertEnd2(20);
		insertEnd2(30);
		printLinkedList(head);
		System.out.println("second implementation");
		insertEnd2(40);
		insertEnd2(50);
		insertEnd2(60);
		printLinkedList(head);


	}

	static void insertEnd(int value) {
		Node temp = new Node(value);
		Node curr = head;
		if (head == null) {
			head = temp;
		} else {
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = temp;
		}
	}


	static void insertEnd2(int value) {
		Node temp = new Node(value);
		if (head == null) {
			head = temp;
			end=temp;
		} else {
			end.next=temp;
			end = temp;
		}
	}

	static Node insertEndReturnHead(int value) {
		Node temp = new Node(value);
		if (head == null) {
			head = temp;
			end=temp;
		} else {
			end.next=temp;
			end = temp;
		}
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
