package com.linkedlist;

public class PairwiseSwapping {
	static Node head = null;

	public static void main(String[] args) {
		PairwiseSwapping list = new PairwiseSwapping();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(30);
		list.head.next.next.next = new Node(40);
		list.head.next.next.next.next = new Node(50);
		list.head.next.next.next.next.next = new Node(60);
		list.head.next.next.next.next.next.next = new Node(70);
		printLinkedList(pairwise_swap(head));
	}

	public static Node pairwise_swap(Node head) {
		if(head==null || head.next==null) {
			return head;
		}
		Node next = head.next.next;
		head.next.next=head;
		Node temp=head.next;
		temp.next=head;
		head.next=next;
		Node prev=head;
		head=next;

		while(head!=null&& head.next!=null) {
			next = head.next.next;
			head.next.next=head;
			Node temps=head.next;
			temps.next=head;
			head.next=next;
		    prev.next=temps;
		    prev=temps.next;
		    head=next;
		}

		return temp;


	}

	private static void printLinkedList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
}
