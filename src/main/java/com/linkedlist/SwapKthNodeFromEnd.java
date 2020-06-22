package com.linkedlist;

public class SwapKthNodeFromEnd {
	static Node head = null;

	public static void main(String[] args) {
		SwapKthNodeFromEnd list = new SwapKthNodeFromEnd();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = new Node(50);
		list.head.next.next.next.next.next = new Node(60);
		Node heads = swapkthnode(head, 6, 2);
		printLinkedList(heads);
	}

	static Node swapkthnode(Node head, int num, int k)
	{
		Node curr1 = head;
		int l = 1;
		while (curr1 != null && l < k - 1) {
			curr1 = curr1.next;
			l++;
		}

		Node curr2 = head;
		int m = num - k;
		int j = 1;
		while (curr2 != null && j < m) {
			curr2 = curr2.next;
			j++;
		}

		Node next1 = curr1.next.next;
		Node next2 = curr2.next.next;

		Node actual1=curr1.next;
		Node actual2= curr2.next;

//		curr1.next=actual2;
//		actual2.next=next1;
//
//		curr2.next=actual1;
//		actual1.next=next2;

		curr2.next=actual1;
		actual1.next=actual2;
		actual2.next=next1;

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
