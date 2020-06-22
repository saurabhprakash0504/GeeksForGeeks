package com.linkedlist;

public class MergeTwoSortedList {
	static Node head1 = null;
	static Node head2 = null;

	public static void main(String[] args) {
		MergeTwoSortedList list = new MergeTwoSortedList();
		list.head1 = new Node(10);
		list.head1.next = new Node(120);
		list.head1.next.next = new Node(320);
		list.head1.next.next.next = new Node(480);
		list.head1.next.next.next.next = new Node(48033);

		MergeTwoSortedList list2 = new MergeTwoSortedList();
		list2.head2 = new Node(110);
		list2.head2.next = new Node(120);
		list2.head2.next.next = new Node(130);
		list2.head2.next.next.next = new Node(4550);

		printLinkedList(merge2(head1, head2));
	}

	private static void printLinkedList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}

	static Node merge(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		Node curr1 = head1;
		Node curr2 = head2;
		Node newHead = null;
		Node tail = null;
		while (curr1 != null && curr2 != null) {
			if (curr1.data < curr2.data) {
				if (newHead == null) {
					newHead = curr1;
					tail = newHead;
				} else {
					tail.next = curr1;
					tail = tail.next;
				}
				curr1 = curr1.next;
			} else {
				if (newHead == null) {
					newHead = curr2;
					tail = newHead;
				} else {
					tail.next = curr2;
					tail = tail.next;
				}
				curr2 = curr2.next;
			}
		}
		if (curr1 == null) {
			while (curr2 != null) {
				tail.next = curr2;
				tail = tail.next;
				curr2 = curr2.next;
			}
		} else {
			while (curr1 != null) {
				tail.next = curr1;
				tail = tail.next;
				curr1 = curr1.next;
			}
		}
		return newHead;
	}

	static Node merge2(Node head1, Node head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		Node curr1 = head1;
		Node curr2 = head2;

		Node newHead = null;
		Node tail = null;

		if (curr1.data < curr2.data) {
			newHead = tail = curr1;
			curr1 = curr1.next;
		} else {
			newHead = tail = curr2;
			curr2 = curr2.next;
		}

		while (curr1 != null && curr2 != null) {
			if (curr1.data < curr2.data) {
				tail.next = curr1;
				tail = tail.next;
				curr1 = curr1.next;
			} else {
				tail.next = curr2;
				tail = tail.next;
				curr2 = curr2.next;
			}
		}
		if (curr1 == null) {
			tail.next=curr2;
		} else {
			tail.next=curr1;
		}
		return newHead;
	}
}
