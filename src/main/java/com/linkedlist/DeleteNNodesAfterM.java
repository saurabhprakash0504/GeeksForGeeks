package com.linkedlist;

public class DeleteNNodesAfterM {
	static Node head1 = null;

	public static void main(String[] args) {
		DeleteNNodesAfterM list = new DeleteNNodesAfterM();
		list.head1 = new Node(9);
		list.head1.next = new Node(1);
		list.head1.next.next = new Node(3);
		list.head1.next.next.next = new Node(5);
		list.head1.next.next.next.next = new Node(9);
		list.head1.next.next.next.next.next = new Node(4);
		list.head1.next.next.next.next.next.next = new Node(10);
		list.head1.next.next.next.next.next.next.next = new Node(1);
		linkdelete(head1, 2, 1);
		printing(head1);

	}

	static void linkdelete(Node head, int M, int N) {
		Node curr = head;
		while (curr != null) {
			int k = 1;
			while (curr != null && k < M) {
				curr = curr.next;
				k = k + 1;
			}
			int j = 1;
			if (curr != null) {
				Node temp = curr.next;
				while (temp != null && j <= N) {
					temp = temp.next;
					j = j + 1;
				}
				if (curr != null) {
					curr.next = temp;
					curr=temp;
				}
			}
		}
	}

	private static void printing(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}

}
